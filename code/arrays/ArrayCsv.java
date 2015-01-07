import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayCsv {

    public static void main(String[] args) throws FileNotFoundException {
        File dataFile = new File("array-data.csv");
        Scanner fileReader = new Scanner(dataFile);
        fileReader.useDelimiter("[,\n]");
        int[][] data = new int[3][5];
        for (int row = 0; row < 3; ++row) {
            System.out.print("Read: ");
            for (int col = 0; col < 5; ++col) {
                data[row][col] = fileReader.nextInt();
                System.out.print(data[row][col] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 5; ++col) {
                System.out.print(data[row][col] + " ");
            }
            System.out.println();
        }
    }
}
