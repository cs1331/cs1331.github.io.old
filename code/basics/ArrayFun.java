public class ArrayFun {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            System.out.println("args[" + i + "]=" + args[i]);
        }
        double[] scores = {99, 56, 78, 99, 45};
        for (int i = 0; i < scores.length; ++i) {
            System.out.println(scores[i]);
        }
        String name = "Luka";
        System.out.println("name.length()=" + name.length());
        System.out.println("scores.length=" + scores.length);
    }
}
