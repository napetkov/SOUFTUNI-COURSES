package NestedLoops.MoreExercises;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 'a'; k < 'a' + l; k++) {
                    for (int m = 'a'; m < 'a' + l; m++) {
                        for (int o = 1; o <= n; o++) {
                            if (i >= o || j >= o) {
                                continue;
                            }
                            System.out.printf("%d%d%c%c%d ",i,j,k,m,o);

                        }

                    }

                }

            }

        }

    }
}
