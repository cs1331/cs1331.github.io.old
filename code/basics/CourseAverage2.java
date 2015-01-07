public class CourseAverage2 {
    public static void main(String[] args) {
        double hwAvg = 74.2;
        double examAvg = (81 + 91 + 93) / 3;
        double finalExam = 89;
        double courseAvg = (.2 * hwAvg) + .6 * examAvg + .2 * finalExam;
        System.out.println("Course average: " + courseAvg);
    }
}
