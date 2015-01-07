public class Smiley {

    public static void main(String[] args) {
        char[][] grid = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                         {' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', ' '},
                         {' ', '*', '*', ' ', ' ', ' ', ' ', '*', '*', ' '},
                         {' ', ' ', ' ', ' ', '*', '*', ' ', ' ', ' ', ' '},
                         {' ', ' ', ' ', ' ', '*', '*', ' ', ' ', ' ', ' '},
                         {' ', '*', ' ', ' ', ' ', ' ', ' ', ' ', '*', ' '},
                         {' ', ' ', '*', ' ', ' ', ' ', ' ', '*', ' ', ' '},
                         {' ', ' ', ' ', '*', '*', '*', '*', ' ', ' ', ' '},
                         {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};

        // Row-major smiley
        System.out.println("Row-major smiley:");
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }

        // Column-major smiley.
        // Note that we're assuming each row is same length
        System.out.println("Column-major smiley:");
        for (int col = 0; col < grid[0].length; ++col) {
            for (int row = 0; row < grid.length; ++row) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }

        // Row-major smiley using nested for-each
        System.out.println("Row-major smiley using nested for-each:");
        for (char[] row: grid) {
            for (char cell: row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
