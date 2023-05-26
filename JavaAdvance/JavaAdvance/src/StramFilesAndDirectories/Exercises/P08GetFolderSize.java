package StramFilesAndDirectories.Exercises;

import java.io.File;
import java.util.ArrayDeque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("Exercises-Resources/Exercises Resources");

        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumOfBytes = 0;

        while(!directories.isEmpty()){

            File currentFile = directories.poll();
            File[] files = currentFile.listFiles();

            for (File file : files) {

                if(file.isDirectory()){
                    directories.push(file);

                }else{
                    sumOfBytes += file.length();
                }
            }
        }

        System.out.printf("Folder size: %d",sumOfBytes);


    }
}
