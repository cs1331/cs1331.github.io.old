public class Average {

    public static void main(String[] args) {
        double sum = 0.0;
        for (String arg: args) {
            double num = Double.parseDouble(arg);
            sum = sum + num;
        }
        System.out.println(sum / args.length);
    }
}
