import registration.Course;
import registration.Student;
import registration.Department;
import registration.LectureDays;
import registration.LectureTime;
import utils.Time;

public class Test {
    public static void main(String[] args) {
        if (!testDepartment()) {
            System.out.println("There appears to be a problem with your"
                + "Department toString method!");
        }
        if (!testStudentConstructor()) {
            System.out.println("In Student, there seems to be a problem"
                + " with either your constructor and instance data, or"
                + " getter methods");
        }
        if (!testCourseConstructor()) {
            System.out.println("In Course, there seems to be a problem"
                + " with either your constructor and instance data"
                + " getter methods, or toString() method");
        }
        if (!testGetRegisteredPosition()) {
            System.out.println("There appears to be a problem with"
                + " getRegisteredPosition method.");
        }
        if (!testStudentRegistered()) {
            System.out.println("There apprears to be a problem with your"
                + " courses[] and waitlists[] array in student after having"
                + " added a course and the student succesfully getting in");
        }
        if (!testRegisteredResizing()) {
            System.out.println("It seems that your courses array in Student"
                + "isn't resizing properly");
        }
        if (!testStudentWaitlisted()) {
            System.out.println("There appears to be a problem with your"
                + " courses[] and waitlists[] array in student after having"
                + " added a course and the student being waitlisted");
        }
        if (!testRegisteredForCourseInCourses()) {
            System.out.println("registeredForCourse doesn't seem" +
                "to work when a student successfully gets into a course");
        }
        if (!testRegisteredForCourseInWaitlists()) {
            System.out.println("registeredForCourse doesn't seem" +
                "to work when a student is waitlisted in a course");
        }
        if (!testDuplicateRegistration()) {
            System.out.println("Your registration system seems allow"
                + "registering the same student multiple times.");
        }
        if (!testFullRegistration()) {
            System.out.println("Possible Problem with numStudentsRegistered"
                + "when course gets full/ able to add more students than"
                + "classSize + waitlistCap");
        }
        if (!testMaxWaitlist()) {
            System.out.println("I appear to be able to add more than 5 courses"
                + " to a students waitlists array.");
        }
        if (!testMaxCredits()) {
            System.out.println("There seems to be a problem with stopping"
                + " students from taking and being waitlisted for"
                + " STRICTLY MORE than a total of 18 credits");
        }
        if (!testNotAvailableRegistrationSuccess()) {
            System.out.println("There seems to be a problem with stopping"
                + " students from taking course that overlap");
        }
        if (!testNotAvailableRegistrationWaitlist()) {
            System.out.println("There seems to be a problem with stopping"
                + " students from having waitlisted courses that overlap");
        }
        if (!testNotAvailableRegistrationMixed()) {
            System.out.println("There seems to be a problem with stopping"
                + " students from taking a course that conflicts with"
                + " a waitlisted course.");
        }
        if (!testSetClassSize()) {
            System.out.println("There seems to be a problem with your"
                + "setClassSize method in Course.");
        }
        System.out.println("Tests Completed."
            + " If you see no error messages above you passed all the tests!");
    }

    public static boolean testDepartment() {
        boolean output = true;
        output = output && Department.COMPUTERSCIENCE.toString().equals("CS");
        output = output && Department.MATHEMATICS.toString().equals("MATH");
        output = output && Department.PHYSICS.toString().equals("PHYS");
        output = output && Department.ELECTRICALENGINEERING.toString()
            .equals("EE");
        output = output && Department.LITERATUREMEDIAANDCOMMUNICATION.toString()
            .equals("LMC");
        return output;
    }

    public static boolean testStudentConstructor() {
        boolean out = true;
        Student student = new Student("Frank");
        out = out && (student.getCredits() == 0);
        out = out && (student.getName().equals("Frank"));
        out = out && arrayEquals(student.getCourses(), new Course[5]);
        out = out && arrayEquals(student.getWaitlists(), new Course[5]);
        out = out && (student.getNumCoursesRegistered() == 0);
        out = out && (student.getNumCoursesWaitlisted() == 0);
        return out;
    }

    public static boolean testCourseConstructor() {
        boolean out = true;
        Course course = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            110, 50, new LectureTime(LectureDays.TTH, 12, 00, 14, 30));
        out = out && (Course.getNumCoursesOffered() == 1);
        out = out && (course.toString().equals("CS1331"));
        out = out && (course.getCredits() == 3);
        out = out && (course.getDept() == Department.COMPUTERSCIENCE);
        out = out && arrayEquals(course.getRegisteredStudents(),
            new Student[160]);
        out = out && (course.getRegisteredStudents().length == 160);
        out = out && (course.getNumStudentsRegistered() == 0);
        out = out && (course.getClassSize() == 110);
        out = out && (course.getTime().getStartTime().toString().equals("12:0"));
        out = out && (course.getTime().getEndTime().toString().equals("14:30"));
        out = out && (Course.getNumCoursesOffered() == 1);
        return out;

    }
    public static boolean testGetRegisteredPosition() {
        Student[] students = new Student[10];
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            5, 20, new LectureTime(LectureDays.TTH, 12, 00, 14, 30));
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student("Rupert" + i);
            students[i].signUp(CS1331);
        }
        boolean out = true;
        out = out && (CS1331.getRegisteredPosition(5) == students[5]);
        out = out && (CS1331.getRegisteredPosition(15) == null);
        out = out && (CS1331.getRegisteredPosition(30) == null);
        return out;
    }

    public static boolean testDuplicateRegistration() {
        Student student = new Student("Rupert");
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            110, 50, new LectureTime(LectureDays.TTH, 12, 00, 14, 30));
        student.signUp(CS1331);
        student.signUp(CS1331);
        student.signUp(CS1331);
        return (CS1331.getNumStudentsRegistered() == 1);
    }

    public static boolean testFullRegistration() {
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            5, 2, new LectureTime(LectureDays.TTH, 12, 00, 14, 30));
        for (int i = 0; i < 10; i++) {
            Student student = new Student("Rupert" + i);
            student.signUp(CS1331);
        }
        return (CS1331.getNumStudentsRegistered() == 7);
    }

    public static boolean testMaxWaitlist() {
        Course[] courses = new Course[6];
        Student student = new Student("Billy");
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new Course(Department.COMPUTERSCIENCE, 1331, 2,
                0, 2, new LectureTime(LectureDays.MWF, i, 00, i, 30));
            student.signUp(courses[i]);
        }
        boolean out = true;
        out = out && (student.getWaitlists().length == 5);
        for (int i = 0; i < 5 && out; i++) {
            out = out && contains(courses[i], student.getWaitlists());
        }
        return out && !contains(courses[5], student.getWaitlists());
    }

    public static boolean testMaxCredits() {
        Course course1 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            5, 2, new LectureTime(LectureDays.MWF, 8, 00, 8, 30));
        Course course2 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            5, 2, new LectureTime(LectureDays.MWF, 9, 00,9, 30));
        Course course3 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            5, 2, new LectureTime(LectureDays.MWF, 10, 00, 10, 30));
        Student student = new Student("Billy");
        student.signUp(course1);
        student.signUp(course2);
        student.signUp(course3);
        boolean out = true;
        out = out && (student.getNumCoursesRegistered() == 2);
        out = out && contains(course1, student.getCourses());
        out = out && contains(course2, student.getCourses());
        return out && !contains(course3, student.getCourses());
    }

    public static boolean testNotAvailableRegistrationSuccess() {
        Course course1 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            5, 2, new LectureTime(LectureDays.MWF, 8, 00, 8, 30));
        Course course2 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            5, 2, new LectureTime(LectureDays.MWF, 8, 15, 8, 45));
        Student student = new Student("Billy");
        student.signUp(course1);
        student.signUp(course2);
        boolean out = true;
        out = out && (student.getNumCoursesRegistered() == 1);
        out = out && contains(course1, student.getCourses());
        return out;
    }

    public static boolean testNotAvailableRegistrationWaitlist() {
        Course course1 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            0, 2, new LectureTime(LectureDays.MWF, 8, 00, 8, 30));
        Course course2 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            0, 2, new LectureTime(LectureDays.MWF, 8, 15, 8, 45));
        Student student = new Student("Billy");
        student.signUp(course1);
        student.signUp(course2);
        boolean out = true;
        out = out && (student.getNumCoursesWaitlisted() == 1);
        out = out && contains(course1, student.getWaitlists());
        return out;
    }

    public static boolean testNotAvailableRegistrationMixed() {
        Course course1 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            0, 2, new LectureTime(LectureDays.MWF, 8, 00, 8, 30));
        Course course2 = new Course(Department.COMPUTERSCIENCE, 1331, 9,
            5, 2, new LectureTime(LectureDays.MWF, 8, 15, 8, 45));
        Student student = new Student("Billy");
        student.signUp(course1);
        student.signUp(course2);
        boolean out = true;
        out = out && (student.getNumCoursesWaitlisted() == 1);
        out = out && contains(course1, student.getWaitlists());
        return out;
    }

    public static boolean testStudentRegistered() {
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            5, 2, new LectureTime(LectureDays.MWF, 12, 00, 14, 30));
        Student student = new Student("Billy");
        student.signUp(CS1331);
        return contains(CS1331, student.getCourses()) &&
            !contains(CS1331, student.getWaitlists());
    }

    public static boolean testRegisteredResizing() {
        Course[] courses = new Course[6];
        Student student = new Student("Billy");
        for (int i = 0; i < courses.length; i++) {
            courses[i] = new Course(Department.COMPUTERSCIENCE, 1331, 2,
                5, 2, new LectureTime(LectureDays.MWF, i, 00, i, 30));
            student.signUp(courses[i]);
        }
        return student.getCourses().length == 10;
    }

    public static boolean testStudentWaitlisted() {
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            0, 2, new LectureTime(LectureDays.MWF, 12, 00, 14, 30));
        Student student = new Student("Billy");
        student.signUp(CS1331);
        return !contains(CS1331, student.getCourses()) &&
            contains(CS1331, student.getWaitlists());
    }
    public static boolean testRegisteredForCourseInCourses() {
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            15, 2, new LectureTime(LectureDays.MWF, 12, 00, 14, 30));
        Student student = new Student("Billy");
        student.signUp(CS1331);
        return student.registeredForCourse(CS1331);
    }
    public static boolean testRegisteredForCourseInWaitlists() {
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            0, 2, new LectureTime(LectureDays.MWF, 12, 00, 14, 30));
        Student student = new Student("Billy");
        student.signUp(CS1331);
        return student.registeredForCourse(CS1331);
    }
    public static boolean testSetClassSize() {
        Course CS1331 = new Course(Department.COMPUTERSCIENCE, 1331, 3,
            5, 10, new LectureTime(LectureDays.MWF, 12, 00, 14, 30));
        Student[] students = new Student[10];
        for (int i = 0; i < 10; i++) {
            students[i] = new Student("Rupert" + i);
            students[i].signUp(CS1331);
        }
        CS1331.setClassSize(20);
        boolean out = true;
        for (int i = 0; i < 10; i++) {
            out = out && contains(CS1331, students[i].getCourses());
            out = out && !contains(CS1331, students[i].getWaitlists());
        }
        CS1331.setClassSize(10);
        out = out && (CS1331.getClassSize() == 20);
        return out;
    }
    public static boolean arrayEquals(Student[] arr1, Student[] arr2) {
        if (arr2.length != arr1.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(Student student, Student[] arr1) {
        for (Student stud : arr1) {
            if (student == stud) {
                return true;
            }
        }
        return false;
    }

    public static boolean arrayEquals(Course[] arr1, Course[] arr2) {
        if (arr2.length != arr1.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(Course item, Course[] arr1) {
        for (Course course : arr1) {
            if (item == course) {
                return true;
            }
        }
        return false;
    }
}
