public class GradeBook {

    private int[] scores;
    private int lastScore;

    public GradeBook() {
        this(10);
    }
    
    public GradeBook(int capacity) {
        scores = new int[capacity];
        lastScore = 0;
    }

    public void add(int score) {
        scores[lastScore++] = score;
    }

    public void modifyScore(int index, int newScore) {
        scores[index] = newScore;
    }

    public int[] getScores() {
        return scores;
    }
}
