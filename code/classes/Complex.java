public class Complex {
    // These are the data of the ADT

    private double real;
    private double imaginary;

    // These are the operations of the ADT

    public Complex(double real, double anImaginary) {
        this.real = real;
        imaginary = anImaginary;
    }

    public Complex plus(Complex other) {
        double resultReal = this.real + other.real;
        double resultImaginary = this.imaginary + other.imaginary;
        return new Complex(resultReal, resultImaginary);
    }

    public String toString() {
        return "Complex(" + real + ", " + imaginary + ")";
    }

    public static void main(String[] args) {
        Complex a = new Complex(1.0, 2.0);
        Complex b = new Complex(3.0, 4.0);
        Complex c = a.plus(b);
        System.out.println(a + " plus " + b + " = " + c);
    }
}
