public class Main {

    public static void main(String[] args) {
        Complex a = new Complex(1.0, 2.0);
        Complex b = new Complex(3.0, 4.0);
        Complex c = a.plus(b);
        System.out.println(a + " + " + b + " = " + c);
    }
}
