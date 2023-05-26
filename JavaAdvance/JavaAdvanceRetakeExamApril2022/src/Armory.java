import java.util.Scanner;

public class Armory {
    private static int rowOfficer;
    private static int colOfficer;
    private static int rowFirstMirror;
    private static int colFirstMirror;
    private static int rowSecondMirror;
    private static int colSecondMirror;
    private static boolean findMirror = false;
    private static int goldenCoins = 0;
    private static boolean isOutOfBounds = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] armory = new char[size][size];

        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine();
            armory[row] = input.toCharArray();
            if (input.contains("A")) {
                rowOfficer = row;
                colOfficer = input.indexOf('A');
            }
            findMirror(row, input);
        }


        while (goldenCoins < 65) {
            String command = scanner.nextLine();
            armory[rowOfficer][colOfficer] = '-';

            switch (command) {
                case "up":
                    rowOfficer--;
                    moveOfficer(armory);
                    break;
                case "down":
                    rowOfficer++;
                    moveOfficer(armory);
                    break;
                case "left":
                    colOfficer--;
                    moveOfficer(armory);
                    break;
                case "right":
                    colOfficer++;
                    moveOfficer(armory);
                    break;
            }
            if (isOutOfBounds) {
                System.out.println("I do not need more swords!");
                break;
            }
            armory[rowOfficer][colOfficer] = 'A';

//            System.out.println("<+++++++++++>");
//            print(armory);
//            System.out.println(goldenCoins);
        }
        if(goldenCoins>=65){
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n",goldenCoins);

        print(armory);

    }

    private static void moveOfficer(char[][] armory) {
        if (officerOutOfBounds(armory, rowOfficer, colOfficer)) {
            isOutOfBounds = true;
        } else {
            char position = armory[rowOfficer][colOfficer];
            if (Character.isDigit(position)) {
                goldenCoins += Integer.parseInt(Character.toString(position));
                ;
            } else if (position == 'M') {

                if (rowOfficer == rowFirstMirror) {
                    rowOfficer = rowSecondMirror;
                    colOfficer = colSecondMirror;
                    armory[rowFirstMirror][colFirstMirror] = '-';
                } else {
                    rowOfficer = rowFirstMirror;
                    colOfficer = colFirstMirror;
                    armory[rowSecondMirror][colSecondMirror] = '-';
                }
            }
        }
    }

    private static boolean officerOutOfBounds(char[][] armory, int rowOfficer, int colOfficer) {
        return rowOfficer < 0 || rowOfficer > armory.length-1 || colOfficer < 0 || colOfficer > armory[rowOfficer].length-1;
    }

    private static void findMirror(int row, String input) {
        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);
            if (chars == 'M') {
                if (findMirror) {
                    rowSecondMirror = row;
                    colSecondMirror = i;
                } else {
                    rowFirstMirror = row;
                    colFirstMirror = i;
                    findMirror = true;
                }
            }
        }
    }

    public static void print(char[][] armory) {
        for (char[] chars : armory) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
