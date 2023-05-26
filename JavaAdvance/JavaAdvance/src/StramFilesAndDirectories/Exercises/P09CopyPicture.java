package StramFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Exercises-Resources/picture.png");

        FileOutputStream fos = new FileOutputStream("Exercises-Resources/pictureCopy.png");

        byte[] buffer = new byte[1024];

        while(fis.read(buffer)!=-1){
            fos.write(buffer);
        }

        fis.close();
        fos.close();
    }
}
