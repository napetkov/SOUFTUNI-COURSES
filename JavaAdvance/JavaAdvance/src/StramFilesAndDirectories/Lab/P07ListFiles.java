package StramFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class P07ListFiles {
    public static void main(String[] args) throws IOException {
        String address = "resources/Files-and-Streams";

        File root = new File(address);

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(root);

        int counterFolders = 0;

        while (!queue.isEmpty()) {

            File file = queue.poll();
            System.out.println(file.getName());
            counterFolders++;
            if (file.isDirectory()) {
                File[] files = file.listFiles();

                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }


            }
        }
        System.out.println(counterFolders + " folders");

    }
}
