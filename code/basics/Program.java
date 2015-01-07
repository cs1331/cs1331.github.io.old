public class Program {
    public static void main(String[] args) {
        float twoThirds = 2 / 3f;
        System.out.println("twoThirds=" + twoThirds);

        double dtwoThirds = 2.0 / 3;
        System.out.println("dtwoThirds=" + dtwoThirds);

        double one = dtwoThirds / dtwoThirds;
        System.out.println("one=" + one);


        int x = 1;
        x++;
        System.out.println("After x = 1; ++x, x=" + x);

        x += 2;
        System.out.println("After x += 2, x=" + x);
        //
        // int threeFourths = (int) (3.0/4.0);
        // System.out.println(threeFourths);
    }
}
