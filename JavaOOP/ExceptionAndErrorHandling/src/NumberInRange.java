import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rangeNUmbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startNumber = rangeNUmbers[0];
        int endNumber = rangeNUmbers[1];

        System.out.println("Range: [" + startNumber + "..." + endNumber + "]");

        boolean isValidInput = false;

        while (!isValidInput) {
            String nextInput = scanner.nextLine();

            Optional<Integer> number = Optional.empty();

            try {
                 number = Optional.of(Integer.parseInt(nextInput));
            } catch (NumberFormatException ignored){
            }

            String output;

            if (number.isPresent()&&isInRange(number.get(), rangeNUmbers)) {
                output = "Valid number: "+number.get();
                isValidInput = true;
            }else {
                output = "Invalid number: " + nextInput;
            }
            System.out.println(output);
        }
    }

    private static boolean isInRange(int number, int[] rangeNUmbers) {
        return  rangeNUmbers[0] <= number && rangeNUmbers[1] >= number;
    }

}
