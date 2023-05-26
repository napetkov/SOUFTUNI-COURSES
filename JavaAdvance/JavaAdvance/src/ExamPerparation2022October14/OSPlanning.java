package ExamPerparation2022October14;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int endTask = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty()) {

            int currentTask = tasks.pop();
            int currentThread = 0;
            if (currentTask == endTask) {
                currentThread = threads.peek();
                System.out.printf("Thread with value %d killed task %d%n", currentThread, endTask);
                for (Integer thread : threads) {
                    System.out.print(thread + " ");
                }
                break;
            }

            currentThread = threads.poll();

            if (currentThread < currentTask) {
                tasks.push(currentTask);
            }

        }
    }
}
