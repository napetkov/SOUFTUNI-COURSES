package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileNames = scanner.nextLine();

        ArrayDeque<String> printQueue = new ArrayDeque<>();

        while(!fileNames.equals("print")){
            if(fileNames.equals("cancel")){
                if(printQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + printQueue.poll());
                }
                }else{
                printQueue.offer(fileNames);
            }

            fileNames = scanner.nextLine();
        }

            printQueue.forEach(element-> System.out.println(element));



    }
}
