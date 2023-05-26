import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        int myRow = -1;
        int myCol = -1;
        int playersCount = 0;
        int moves = 0;
        int playersTouch = 0;

        String[][] playground = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputRows = scanner.nextLine().split("\\s+");
            for (int j = 0; j < inputRows.length; j++) {
                String currentSymbol = inputRows[j];
                if ("P".equals(currentSymbol)) {
                    playersCount++;
                } else if ("B".equals(currentSymbol)) {
                    myRow = i;
                    myCol = j;
                }
                playground[i][j] = inputRows[j];
            }
        }
        playground[myRow][myCol] = "-";

        String command = scanner.nextLine();

        while (!command.equals("Finish") && playersTouch != playersCount) {
            int nextRow = myRow;
            int nextCol = myCol;
            switch (command) {
                case "up":
                    nextRow = myRow - 1;
                    break;
                case "down":
                    nextRow = myRow + 1;
                    break;
                case "left":
                    nextCol = myCol - 1;
                    break;
                case "right":
                    nextCol = myCol + 1;
                    break;
            }
            if (indexValidation(nextRow, nextCol, playground)) {
                if (playground[nextRow][nextCol].equals("P")) {
                    playersTouch++;
                }
                moves++;
                myRow = nextRow;
                myCol = nextCol;
            }

            command = scanner.nextLine();
        }


        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", playersTouch, moves);


    }

    private static boolean indexValidation(int row, int col, String[][] playground) {
        return row >= 0 && row < playground.length && col >= 0 && col < playground[0].length && !playground[row][col].equals("O");
    }

    private static void print(String[][] playground) {
        for (String symbols[] : playground) {
            System.out.println(String.join(" ", symbols));
        }
    }
}
