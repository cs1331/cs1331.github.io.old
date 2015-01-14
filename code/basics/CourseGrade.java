public class CourseGrade {

    public static void main(String[] args) {
        double homeworkAverage = 74.2;
        double exam1 = 81;
        double exam2 = 93;
        double exam3 = 95;
        double finalExam = 89;
        double examAverage = (exam1 + exam2 + exam3) / 3;
        double courseAverage = (.2 * homeworkAverage) + (.6 * examAverage)
            + (.2 * finalExam);
        System.out.println("Course Average: " + courseAverage);
        char grade = 'F';
        if (courseAverage >= 90) {
            grade = 'A';
        } else if (courseAverage >= 80) {
            grade = 'B';
        } else if (courseAverage >= 70) {
            grade = 'C';
        } else if (courseAverage >= 60) {
            grade = 'D';
        }
        System.out.println("Course Grade: " + grade);
    }
}
