import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Comparator;

public class WordCount {

    private Map<String, Integer> wordCounts;
    private int totalCount;

    public WordCount(String fileName) throws FileNotFoundException {
        wordCounts = new HashMap<>();
        Scanner fileScanner = new Scanner(new File(fileName));
        while (fileScanner.hasNext()) {
            totalCount++;
            String curWord = fileScanner.next();
            if (wordCounts.get(curWord) == null) {
                // new word
                wordCounts.put(curWord, 1);
            } else {
                // existing word
                int curWordCount = wordCounts.get(curWord);
                wordCounts.put(curWord, curWordCount + 1);
            }
        }
    }

    public Set<String> getWords() {
        return wordCounts.keySet();
    }

    public Set<String> getWordsRankedOld() {
        Comparator<String> rankComparator = new Comparator<String>() {
            public int compare(String k1, String k2) {
                return wordCounts.get(k1) - wordCounts.get(k2);
            }
        };
        TreeSet<String> rankedWords = new TreeSet<>(rankComparator);
        rankedWords.addAll(wordCounts.keySet());
        return rankedWords;
    }

    public Set<String> getWordsRanked() {
        Comparator<String> rankComparator =

            (String k1, String k2) ->
                wordCounts.get(k1) - wordCounts.get(k2);

        TreeSet<String> rankedWords = new TreeSet<>(rankComparator);
        rankedWords.addAll(wordCounts.keySet());
        return rankedWords;
    }

    public int getCount(String word) {
        return wordCounts.get(word);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
        WordCount wc = new WordCount(args[0]);
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "a", "an", "and", "are", "as", "be", "by", "is", "in", "of",
            "for", "from", "not", "to", "the", "that", "this", "with", "which"
        ));
        wc.wordCounts.entrySet().stream()
            .filter(entry -> !stopWords.contains(entry.getKey().toLowerCase()))
            .sorted((e1, e2) -> e1.getValue() - e2.getValue())
            .forEach(entry ->
                System.out.printf("%s occurs %d times%n", entry.getKey(),
                                                          entry.getValue()));

        // for (String word: wc.getWordsRanked()) {
        //     System.out.println(word + " occurs " + wc.getCount(word)
        //                        + " times in " + args[0]);
        // }
        // System.out.println(args[0] + " contains " + wc.getTotalCount()
        //                    + "  words.");
        // System.out.println(args[0] + " contains " + wc.getWords().size()
        //                    + " distinct words.");
    }
}
