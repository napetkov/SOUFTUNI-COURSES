import java.util.Scanner;

public class FishingCompetition {
    private static int shipRow;
    private static int shipCol;
    private static int fishAmount;
    private static boolean fallInWaterfall;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] fishingArea = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            String inputLine = scanner.nextLine();
            for (int col = 0; col < rows; col++) {
                if (inputLine.contains("S")) {
                    shipRow = row;
                    shipCol = inputLine.indexOf('S');
                }

                fishingArea[row] = inputLine.toCharArray();

            }
        }

        String inputLine = scanner.nextLine();

        while (!"collect the nets".equals(inputLine)) {

            fishingArea[shipRow][shipCol] = '-';

            switch (inputLine) {
                case "up":
                    shipRow--;
                    if (shipOutOfBounds(fishingArea, shipRow, shipCol)) {
                        shipRow = fishingArea.length - 1;
                    }
                    break;
                case "down":
                    shipRow++;
                    if (shipOutOfBounds(fishingArea, shipRow, shipCol)) {
                        shipRow = 0;
                    }
                    break;
                case "left":
                    shipCol--;
                    if (shipOutOfBounds(fishingArea, shipRow, shipCol)) {
                        shipCol = fishingArea.length - 1;
                    }
                    break;
                case "right":
                    shipCol++;
                    if (shipOutOfBounds(fishingArea, shipRow, shipCol)) {
                        shipCol = 0;
                    }
                    break;
            }

            char position = fishingArea[shipRow][shipCol];

            if (Character.isDigit(position)) {
                fishAmount += Character.getNumericValue(position);
            } else if (position == 'W') {
                System.out.printf
                        ("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]%n"
                                , shipRow, shipCol);
                fallInWaterfall = true;
                break;
            }


            if (!fallInWaterfall) {
                fishingArea[shipRow][shipCol] = 'S';

//                printFishingArea(fishingArea);

                inputLine = scanner.nextLine();

            }

        }
        if(!fallInWaterfall){
            if (fishAmount >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - fishAmount);
            }

            if (fishAmount > 0){
                System.out.printf("Amount of fish caught: %d tons.%n",fishAmount);
            }

                printFishingArea(fishingArea);
            }



    }


    private static boolean shipOutOfBounds(char[][] fishingArea, int shipRow, int shipCol) {
        return shipRow < 0 || shipRow > fishingArea.length - 1 || shipCol < 0 || shipCol > fishingArea[0].length - 1;
    }

    private static void printFishingArea(char[][] fishingArea) {
        for (int i = 0; i < fishingArea.length; i++) {
            for (int j = 0; j < fishingArea.length; j++) {
                System.out.print(fishingArea[i][j]);
            }
            System.out.println();
        }
    }
}
