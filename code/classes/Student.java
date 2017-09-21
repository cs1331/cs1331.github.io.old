public class Student {

    private String name;
    private int hours;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addHours(int hours) {
        this.hours += hours;
    }

    public int getHours() {
        return hours;
    }

    public int year() {
        return (hours / 30) + 1;
    }

    public static void main(String[] args) {
        Student[] studs = {new Student("Abdallah"), new Student("Barbara"),
                           new Student("Chen"), new Student("Dharma"),
                           new Student("Chen")};
        // Compare primitive values using ==
        System.out.println("studs[2].getHours() == studs[4].getHours(): "
                           + (studs[2].getHours() == studs[4].getHours()));

        // Student is mutable, so this modifies studs[2]
        studs[2].addHours(30);
        System.out.println("studs[1].getHours() == studs[4].getHours(): "
                           + (studs[2].getHours() == studs[4].getHours()));

        // Compare values of reference types using equals method
        System.out.println("studs[2].getName() == studs[4].getName(): "
                           + (studs[2].getName() == studs[4].getName()));
        System.out.println("studs[1].getName() == studs[2].getName(): "
                           + (studs[1].getName() == studs[2].getName()));

    }
}
