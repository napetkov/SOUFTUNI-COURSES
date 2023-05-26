package ObjectsAndClasses.MoreExercises.p01CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine());

        List<CompanyRoster> companyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

            if(inputList.size()<5){
                inputList.add("n/a");
                inputList.add("-1");
            }else if(inputList.size()==5){
                if(inputList.get(4).contains("@")){
                    inputList.add("-1");
                }else{
                    inputList.add(4,"n/a");
                }
            }



            String inputName = inputList.get(0);
            double inputSalary = Double.parseDouble(inputList.get(1));
            String inputPosition = inputList.get(2);
            String inputDepartment = inputList.get(3);
            String inputEmail = inputList.get(4);
            String inputAge = inputList.get(5);

            CompanyRoster currentPerson = new CompanyRoster(inputName,inputSalary,inputPosition,inputDepartment,inputEmail,inputAge);

            companyList.add(currentPerson);

        }

        double maxAverageSalary = Double.MIN_VALUE;
        String maxDepartment = "";
        for (CompanyRoster element:companyList){
            String currentDepartment = element.getDepartment();
            double sumSalary = 0;
            int count = 0;
            double averageSalary = 0;

            for (CompanyRoster secondElement:companyList){
                if(secondElement.getDepartment().equals(currentDepartment)){
                    sumSalary+= secondElement.getSalary();
                    count++;
                }
            }
            averageSalary = sumSalary/count;
            if(maxAverageSalary<=averageSalary){
                maxAverageSalary = averageSalary;
                maxDepartment = currentDepartment;
            }
        }

        companyList.sort(Comparator.comparing(CompanyRoster::getSalary));
        Collections.reverse(companyList);

        System.out.printf("Highest Average Salary: %s%n",maxDepartment);

     for (CompanyRoster element:companyList){
         if(element.getDepartment().equals(maxDepartment)){
             System.out.println(element.toString());
         }

     }

    }
}
