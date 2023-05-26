package StramFilesAndDirectories.Exercises;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Exercises-Resources/inputLineNumbers.txt"));

        PrintWriter pr = new PrintWriter(new FileWriter("Exercises-Resources/output.txt"));

        String line = br.readLine();

        int countLines = 0;

        while (line != null) {
            countLines++;

            pr.println(countLines + ". " + line);

            line = br.readLine();
        }
        br.close();
        pr.close();


    }

}
