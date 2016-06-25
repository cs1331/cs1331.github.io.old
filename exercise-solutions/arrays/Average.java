public class Average {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(0.0);
        } else {
            double sum = 0.0;
            for (String arg: args) {
                double num = Double.parseDouble(arg);
                sum = sum + num;
            }
            System.out.println(sum / args.length);
        }
    }
}
