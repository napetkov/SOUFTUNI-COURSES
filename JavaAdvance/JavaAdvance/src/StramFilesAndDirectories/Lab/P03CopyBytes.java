package StramFilesAndDirectories.Lab;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter printer = new PrintWriter(outputStream);

        int bytes = inputStream.read();

        Set<Integer> delimiterTable = Set.of(10, 32);


        while (bytes != -1) {

            boolean isDelimiter = delimiterTable.contains(bytes);

            if(isDelimiter){
                printer.print((char)bytes);
            }else{
                printer.print(bytes);
            }


            bytes = inputStream.read();

        }


    }
}
