package StramFilesAndDirectories.Exercises;

import java.io.*;

public class P01SumLines {
    public static void main(String[] args) throws IOException {
        String path = "Exercises-Resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        while(line != null){
            int sumOfLine = 0;

            for (int i = 0; i < line.length(); i++) {
                sumOfLine += line.charAt(i);

            }

            System.out.println(sumOfLine);


            line = reader.readLine();

        }

        reader.close();

    }
}
