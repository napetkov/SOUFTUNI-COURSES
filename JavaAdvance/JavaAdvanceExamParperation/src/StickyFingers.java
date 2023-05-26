import java.util.Scanner;
//This case without mutator is TotalSHI...

public class StickyFingers {
    private static int dRow;
    private static int dCol;
    private static int totalMoney;
    private static boolean goToJail = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        String[] commandLine = scanner.nextLine().split(",");

        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine().replaceAll(" ", "");

            if (input.contains("D")) {
                dRow = row;
                dCol = input.indexOf('D');
            }

            matrix[row] = input.toCharArray();
        }

        for (int i = 0; i < commandLine.length; i++) {
            String command = commandLine[i];

            matrix[dRow][dCol] = '+';

            if (command.equals("up")) {
                dRow--;
                if(dillingerOutOfBound(matrix,dRow,dCol)){
                    dRow++;
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (command.equals("down")) {
                dRow++;
                if(dillingerOutOfBound(matrix,dRow,dCol)){
                    dRow--;
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (command.equals("left")) {
                dCol--;
                if(dillingerOutOfBound(matrix,dRow,dCol)){
                    dCol++;
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (command.equals("right")) {
                dCol++;
                if(dillingerOutOfBound(matrix,dRow,dCol)){
                    dCol--;
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            }


            char position = matrix[dRow][dCol];
            int stolenMoney = 0;



            if (position == '$') {
                stolenMoney = dRow * dCol;
                totalMoney += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);

            } else if (position == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                matrix[dRow][dCol] = '#';
                goToJail = true;
                break;
            }

            matrix[dRow][dCol] = 'D';

        }

        if(!goToJail){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",totalMoney);
        }

        print(matrix);
    }

    public static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public static boolean dillingerOutOfBound(char[][] matrix, int dRow, int dCol) {
        return dRow < 0 || dRow > matrix.length - 1 || dCol < 0 || dCol > matrix[dRow].length - 1;
    }
}
