package StramFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstFile = Paths.get("Exercises-Resources/inputOne.txt");
        List<String> firstFileLine = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("Exercises-Resources/inputTwo.txt");
        List<String> secondFileLine = Files.readAllLines(secondFile);

        Path output = Paths.get("Exercises-Resources/output.txt");
        Files.write(output,firstFileLine, StandardOpenOption.APPEND);
        Files.write(output,secondFileLine, StandardOpenOption.APPEND);

    }
}
