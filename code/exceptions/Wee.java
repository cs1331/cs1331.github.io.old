public class Wee {

    static void bar() { // throws Throwable {
        throw new RuntimeException("Wee!");
    }

    static void foo() {
        bar();
        System.out.println("Foo!");

    }

    public static void main(String[] args) {//throws Throwable {
        // foo();
        try {
            foo();
            System.out.println("After the foo() call.");
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        System.out.println("I'm still running.");
    }
}
