package MapsLambdaAndStreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,String> register = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();

            String command = inputLine.split(" ")[0];
            String username = inputLine.split(" ")[1];

            if(command.equals("register")){
                if(register.containsKey(username)){
                    System.out.printf("ERROR: already registered with plate number %s%n",register.get(username));
                }else{
                    String licenseNumber = inputLine.split(" ")[2];
                    register.put(username,licenseNumber);
                    System.out.printf("%s registered %s successfully%n",username,register.get(username));
                }

            }else if(command.equals("unregister")){
                if(register.containsKey(username)){
                    System.out.printf("%s unregistered successfully%n",username);
                    register.remove(username);

                }else{
                    System.out.printf("ERROR: user %s not found%n",username);
                }
            }
        }
        register.entrySet().forEach(element->System.out.printf("%s => %s%n",element.getKey(),element.getValue()));
    }
}
