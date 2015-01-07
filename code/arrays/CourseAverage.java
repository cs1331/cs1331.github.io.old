import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CourseAverage {

    public static void main(String[] args) {
        int[] exams = new int[3];
        double examAvg, hwAvg, finalExam, courseAvg;
        Scanner gradeFile = null;
        try {
            gradeFile = new Scanner(new FileInputStream("grades.txt"));
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        for (int i = 0; i < 3; ++i) {
            exams[i] = gradeFile.nextInt();
        }
        examAvg = calcAverage(exams);
        hwAvg = gradeFile.nextDouble();
        finalExam = gradeFile.nextDouble();
        courseAvg = .2 * hwAvg + .6 * examAvg + .2 * finalExam;
        System.out.printf("Your course average is %.1f%n", courseAvg);
    }

    private static double calcAverage(int[] numbers) {
        double sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }
}
