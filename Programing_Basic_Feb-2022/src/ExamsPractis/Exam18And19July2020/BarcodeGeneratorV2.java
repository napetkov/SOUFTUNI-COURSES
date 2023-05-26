package ExamsPractis.Exam18And19July2020;

import java.util.Scanner;

public class BarcodeGeneratorV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int unitsStart = start % 10;
        int unitsEnd = end % 10;
        int tensStart = (start / 10) % 10;
        int tensEnd = (end / 10) % 10;
        int hundredsStart = ((start / 10) / 10) % 10;
        int hundredsEnd = ((end / 10) / 10) % 10;
        int thousandsStart = (((start / 10) / 10) / 10) % 10;
        int thousandsEnd = (((end / 10) / 10) / 10) % 10;

        for (int i = thousandsStart; i <= thousandsEnd; i++) {
            boolean isOddThousand = true;
            if (i % 2 == 0) {
               continue;
                //isOddThousand = false;
            }
            boolean isOddHundred = true;
            for (int j = hundredsStart; j <= hundredsEnd; j++) {
                if (j % 2 == 0) {
                    continue;
                    //isOddHundred = false;
                }
                boolean isOddTens = true;
                for (int k = tensStart; k <= tensEnd; k++) {
                    if (k % 2 == 0) {
                    continue;
                        //    isOddTens = false;
                    }
                    boolean isOddUnit = true;
                    for (int l = unitsStart; l <= unitsEnd; l++) {
                        if (l % 2 == 0) {
                           continue;
                            // isOddUnit = false;
                        }
                        if (isOddHundred && isOddThousand && isOddTens && isOddUnit) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }

                    }

                }

            }

        }

    }
}
