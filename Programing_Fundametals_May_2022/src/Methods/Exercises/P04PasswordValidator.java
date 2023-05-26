package Methods.Exercises;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if(isValid(password)){
            System.out.println("Password is valid");
        }else{
            if(!numbersOfCharacters(password)){
                System.out.println("Password must be between 6 and 10 characters");
            }
            if(!consistLettersAndDigit(password)){
                System.out.println("Password must consist only of letters and digits");
            }
            if(!isHaveTwoDigit(password)){
                System.out.println("Password must have at least 2 digits");
            }
        }





    }
    public static boolean isValid(String password) {
        boolean isValid = false;
        if(numbersOfCharacters(password)&&consistLettersAndDigit(password)&&isHaveTwoDigit(password)){
            isValid = true;
        }
        return isValid;
    }

    public static boolean numbersOfCharacters(String password) {
        boolean isValidNumbersChar = false;
        if (password.length() >= 6 && password.length() <= 10) {
            isValidNumbersChar = true;
        }
        return isValidNumbersChar;
    }

    public static boolean consistLettersAndDigit(String password) {
        boolean isConsistLettersAndDigit = true;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (!((currentSymbol >= 48 && currentSymbol <= 57) || (currentSymbol >= 65 && currentSymbol <= 90) || (currentSymbol >= 97 && currentSymbol <= 122))) {
                isConsistLettersAndDigit = false;
                break;
            }
        }
        return isConsistLettersAndDigit;
    }

    public static boolean isHaveTwoDigit(String password) {
        boolean isHaveTwoDigit = false;
        int counterDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char digits = password.charAt(i);
            if(digits>='0'&&digits<='9'){
                counterDigits++;
            }
            if(counterDigits>=2){
                isHaveTwoDigit = true;
                break;
            }
        }
        return isHaveTwoDigit;
    }


}
