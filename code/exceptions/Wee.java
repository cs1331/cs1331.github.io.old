public class Wee {

    static void bar() throws Throwable {
        throw new RuntimeException("Wee!");
    }

    static void foo() throws Throwable {
        bar();
        System.out.println("Foo!");

    }

    public static void main(String[] args) {
        try {
            foo();
            System.out.println("After the foo() call.");
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        System.out.println("I'm still running.");
    }
}
