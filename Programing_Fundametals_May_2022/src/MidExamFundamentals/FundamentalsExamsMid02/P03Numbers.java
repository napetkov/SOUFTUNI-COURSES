package MidExamFundamentals.FundamentalsExamsMid02;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double averageSumOfElements = sumOfAllElements(numberList)*1.00/ numberList.size();

        List<Integer> greaterNumberList = new ArrayList<>(5);
        for (int i = 0; i < numberList.size(); i++) {
            if(numberList.get(i)>averageSumOfElements){
                greaterNumberList.add(numberList.get(i));
            }
        }

        Collections.sort(greaterNumberList);
        Collections.reverse(greaterNumberList);

        List<Integer> printList = new ArrayList<>();
        int indexCounter = 0;

        for (int i = 0; i < greaterNumberList.size(); i++) {
            indexCounter++;
            printList.add(greaterNumberList.get(i));
            if(indexCounter>=5){
                break;
            }
        }


        if(printList.isEmpty()){
            System.out.println("No");
        }else{
            System.out.println(printList.toString().replaceAll("[\\[\\],]",""));
        }

    }

    private static int sumOfAllElements(List<Integer> numberList) {
            int totalSum = 0;
        for (int currentElement:numberList) {
            totalSum +=currentElement;
        }
    return totalSum;
    }
}
