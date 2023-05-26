package StramFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("Exercises-Resources/input.txt"));

        String line = bufferedReader.readLine();

        while(line!=null){

            String printLine = line.toUpperCase();

            System.out.println(printLine);

            line = bufferedReader.readLine();
        }



    }
}
