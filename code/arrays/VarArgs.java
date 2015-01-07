public class VarArgs {

    public static int max(int ... numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] > max) max = numbers[i];
        }
        return max;
    }

    public static void main(String ... args) {
        int topScore = max(92, 87, 56, 97, 89, 98);
        int [] nums = { 24, 45, 67, 789};
        int topNum = max(nums);
        System.out.printf("Tops score is %d%n", topScore);
    }
}
