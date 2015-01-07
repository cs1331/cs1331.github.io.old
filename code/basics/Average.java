public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        for (String arg: args) {
            double num = Double.parseDouble(arg);
            sum = sum + num;
        }
        double average = sum / args.length;
        System.out.println(average);
    }
}
