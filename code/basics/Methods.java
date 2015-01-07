public class Methods {

    static String message = "Global message.";
    static int a = 5;

    public static int add(int a, int b) {
        String message = "Adding " + a + " and " + b;
        System.out.println(message);
        return a + b;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        // What if we removed the extra parentheses around (x + y)?
        //System.out.println("x + y = " + (x + y));
        System.out.println("x + add(x, y) = " + (x + add(x, y)));
    }

}
