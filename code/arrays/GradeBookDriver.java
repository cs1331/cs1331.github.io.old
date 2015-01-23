public class GradeBookDriver {

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook(3);
        gradeBook.add(80);
        gradeBook.add(74);
        gradeBook.add(92);
        gradeBook.modifyScore(1, 84);
        // Now scores are 80, 84, 92
        System.out.println("GradeBook scores are:");
        for (int score: gradeBook.getScores()) {
            System.out.println(score);
        }
        // Privacy leak: now we have a local reference to a private variable:
        int[] myReferenceToScores = gradeBook.getScores();
        // We can use our local reference to update the private instance var:
        myReferenceToScores[0] = 100;
        // Now scores are 100, 84, 92:
        System.out.println("GradeBook scores are:");
        for (int score: gradeBook.getScores()) {
            System.out.println(score);
        }
    }
}
