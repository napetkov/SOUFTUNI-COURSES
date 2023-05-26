package StramFilesAndDirectories.Exercises;

import java.io.*;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "Exercises-Resources/input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        int sum = 0;

        while(line != null){

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);

            }

            line = reader.readLine();

        }
        System.out.println(sum);

        reader.close();
    }
}
