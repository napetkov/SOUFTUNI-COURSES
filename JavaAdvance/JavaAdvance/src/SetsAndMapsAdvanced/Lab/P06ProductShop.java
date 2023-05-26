package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String,Double>> storeList =new TreeMap<>();

        while(!input.equals("Revision")){
            String store = input.split(", ")[0];
            String product = input.split(", ")[1];
            Double price = Double.parseDouble(input.split(", ")[2]);

            if(storeList.containsKey(store)){
                storeList.get(store).put(product,price);

            }else{
                storeList.put(store,new LinkedHashMap<>());
                storeList.get(store).put(product,price);
            }

            input = scanner.nextLine();
        }

        storeList.forEach((store,productList)->{
            System.out.println(store+"->");
         productList.forEach((k,v)->{
             System.out.printf("Product: %s, Price: %.1f%n",k,v);
         });

        });


    }
}
