package MapsLambdaAndStreamAPI.Exercises;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        Map<String, List<String>> companyInformation = new LinkedHashMap<>();

        while (!inputLine.equals("End")) {
            String company = inputLine.split(" -> ")[0];
            String employeeId = inputLine.split(" -> ")[1];

            if(!companyInformation.containsKey(company)){
                companyInformation.put(company,new ArrayList<>());
                companyInformation.get(company).add(employeeId);
            }else{
                List listOfEmployeeId = companyInformation.get(company);
                if(!listOfEmployeeId.contains(employeeId)){
                    companyInformation.get(company).add(employeeId);
                }
            }
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companyInformation.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(element-> System.out.printf("-- %s%n",element));
        }


    }


    }

