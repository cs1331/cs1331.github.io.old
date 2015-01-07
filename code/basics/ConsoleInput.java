import java.util.Scanner;

class ConsoleInput {

    public static void main(String[] args) {
        int exam1, exam2, exam3;
        double examAvg, hwAvg, finalExam, courseAvg;
        Scanner keyboard = new Scanner(System.in);
        String token1 = keyboard.next();
        exam1 = Integer.parseInt(token1);
        exam2 = keyboard.nextInt();
        exam3 = keyboard.nextInt();

        examAvg = (exam1 + exam2 + exam3) / 3.0; // Why 3.0 instead of 3?
        System.out.printf("Your exam average is %.1f%n", examAvg);
    }
}
