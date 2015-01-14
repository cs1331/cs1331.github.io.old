import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MarkovChain {

    private HashMap<String, int[][]> sourceModels;

    public MarkovChain(HashMap<String, FileInputStream> corpora)
            throws FileNotFoundException {
        sourceModels = new HashMap<String, int[][]>();
        for (String source: corpora.keySet()) {
            sourceModels.put(source, new int[27][27]);
        }
        train(corpora.keySet());
    }


    private void train(Collection<String> trainingFiles)
            throws FileNotFoundException {
        for (String source: trainingFiles) {
            FileInputStream fis =
                new FileInputStream(new File(source + ".corpus"));
            System.out.println("Training " + source + " model.");
            Scanner reader = new Scanner(fis);
            reader.useDelimiter("[.?!]");
            String sentence = reader.next();
            while (sentence != null) {
                learn(source, sentence);
                sentence = reader.next();
            }
        }
    }

    private void learn(String source, String sentence) {
        int[][] freqs = sourceModels.get(source);
        int[] charIndexes = string2CharIndexes(sentence);
        for (int i = 0; i < charIndexes.length - 1; ++i) {
            int row = charIndexes[i];
            int col = charIndexes[i + 1];
            // Increment the count of char[i+1] following char[i]
            freqs[row][col] = freqs[row][col] + 1;
        }
    }

    private int[] string2CharIndexes(String s) {
        char[] chars = s.toUpperCase().toCharArray();
        int[] indexes = new int[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            indexes[i] = Character.getNumericValue(chars[i])
                - Character.getNumericValue('A');
        }
        return indexes;
    }

/*  Scala original. As I port these to Java, I delete them from here so
    this is sort of a t-do list

  def predict(line: String) = {
    val chars = stringToCharIndexes(line)
    var ret = List[(String, Double)]()
    for (source <- corpora.keys) {
      var product = 1.0
      for (i <- Range(0, chars.size - 1)) {
        val row = chars(i)
        val col = chars(i+1)
        product = product * probChars(source, row, col)
      }
      ret = (source, product)::ret
    }
    normalize(ret)
  }

  def probChars(source: String, char1: Int, char2: Int) = {
    val  freqs = sourceModels(source)
    val rowSum = math.max(freqs(char1).sum, 0.01)
    val ret = math.max(freqs(char1)(char2) / rowSum, 0.01)
    ret
  }

  def normalize(probs: List[(String, Double)]) = {
    val sum = probs.map(_._2).sum
    val normalized = probs.map({x: (String, Double) => (x._1, x._2 / sum)})
    normalized.sortWith({(x: (String, Double), y: (String, Double))
      => x._2 > y._2})
  }

*/
}
