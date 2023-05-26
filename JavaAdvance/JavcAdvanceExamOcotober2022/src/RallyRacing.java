import java.util.Scanner;

public class RallyRacing {
    private static int carRow;
    private static int carCol;
    private static int tunnelRow;
    private static int tunnelCol;
    private static int nextTunnelRow;
    private static int nextTunnelCal;
    private static boolean findFirstTunnel = false;
    private static boolean finished = false;
    private static boolean isTheFirstMove = true;
    private static int distance = 0;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine();
            input = input.replace(" ", "");
            matrix[row] = input.toCharArray();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'T') {
                    if (findFirstTunnel) {
                        nextTunnelRow = row;
                        nextTunnelCal = i;
                    } else {
                        tunnelRow = row;
                        tunnelCol = i;
                        findFirstTunnel = true;
                    }
                }
            }
        }
        String command = scanner.nextLine();
        matrix[carRow][carCol] = 'C';
        while (!command.equals("End")) {
            if (isTheFirstMove) {
                driveCar(matrix);
                isTheFirstMove = false;
                distance -=10;
            } else {
                matrix[carRow][carCol] = '.';
                switch (command) {
                    case "up":
                        carRow--;
                        driveCar(matrix);
                        break;
                    case "down":
                        carRow++;
                        driveCar(matrix);
                        break;
                    case "left":
                        carCol--;
                        driveCar(matrix);
                        break;
                    case "right":
                        carCol++;
                        driveCar(matrix);
                        break;
                }


            if (matrix[carRow][carCol] == 'F') {
                matrix[carRow][carCol] = 'C';
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                finished = true;
                break;
            }
            matrix[carRow][carCol] = 'C';

//            System.out.println("<+++++++>");
//            print(matrix);
            command = scanner.nextLine();
        }}
        if (!finished) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);
        print(matrix);
    }

    private static void driveCar(char[][] matrix) {
        distance += 10;
        if (matrix[carRow][carCol] == 'T') {
            distance += 20;
            matrix[carRow][carCol] = '.';
            if (carRow == tunnelRow) {
                carRow = nextTunnelRow;
                carCol = nextTunnelCal;
            } else {
                carRow = tunnelRow;
                carCol = tunnelCol;
            }
        }
    }

    public static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
