public class CourseAverage {

    public static void main(String[] args) {
        double homeworkAvg = 74.2;
        double examAvg = (81 + 91 + 93) / 3;
        double finalExam = 89;
        double courseAverage = (.2 * homeworkAvg) + (.6 * examAvg)
            + (.2 * finalExam);
        System.out.println("Course Average: " + courseAverage);
    }
}
