package SetsAndMapsAdvanced.Exercisses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Map<String,Integer>> usersList = new TreeMap<>();



        while(!input.equals("end")){
            String user = input.split(" ")[2].split("=")[1];
            String ipAddress= input.split(" ")[0].split("=")[1];

           if(usersList.containsKey(user)){
               Map<String,Integer> countMassages = new LinkedHashMap<>();
               countMassages = usersList.get(user);

               if(countMassages.containsKey(ipAddress)) {

                   countMassages.put(ipAddress, countMassages.get(ipAddress) + 1);

                }else{

                   countMassages.put(ipAddress,1);

                }
               usersList.put(user,countMassages);

            }else {

               usersList.put(user, new LinkedHashMap<>());
               usersList.get(user).put(ipAddress, 1);

           }

            input = scanner.nextLine();
        }


        usersList.forEach((k,v) -> {
            System.out.println(k+":");

            StringBuilder print= new StringBuilder();
            usersList.get(k).forEach((ip,count)->{
                print.append(ip);
                print.append(" => ");
                print.append(count);
                print.append(", ");
            });
            print.replace(print.length()-2,print.length()-1,".");

            System.out.println(print.toString());

        });

    }
}
