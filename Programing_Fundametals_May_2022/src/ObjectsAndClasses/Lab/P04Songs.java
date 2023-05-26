package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {

    static class Song {
        String typeList;
        String name;
        String setTime;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setSetTime(String setTime) {
            this.setTime = setTime;
        }

        public String getSetTime() {
            return this.setTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Song> listOfSongs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputSongArr = scanner.nextLine().split("_");

            String inputType = inputSongArr[0];
            String inputName = inputSongArr[1];
            String inputSetTime = inputSongArr[2];

            Song currentSong = new Song();
            currentSong.setTypeList(inputType);
            currentSong.setName(inputName);
            currentSong.setSetTime(inputSetTime);

            listOfSongs.add(currentSong);

        }

        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song item : listOfSongs) {
                System.out.println(item.getName());
            }

        } else {
            for(Song item:listOfSongs){
                if(item.getTypeList().equals(command)){
                    System.out.println(item.getName());
                }
            }
        }


    }
}

