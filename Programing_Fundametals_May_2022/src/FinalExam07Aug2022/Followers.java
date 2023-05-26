package FinalExam07Aug2022;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Integer> likes = new LinkedHashMap<>();
        Map<String,Integer> comments = new LinkedHashMap<>();


        while (!input.equals("Log out")) {
            String command = input.split(": ")[0];
            String username = input.split(": ")[1];
            switch (command) {
                case "New follower":
                    if(!likes.containsKey(username)){
                        likes.put(username,0);
                        comments.put(username,0);
                    }
                    break;
                case "Like":
                    int count = Integer.parseInt(input.split(": ")[2]);

                    if(likes.containsKey(username)){
                        int currentLike = likes.get(username);
                        likes.put(username,currentLike+count);
                    }else{
                    likes.put(username,count);
                    comments.put(username,0);
                    }

                    break;
                case "Comment":
                    if(likes.containsKey(username)){
                    int currentComments = comments.get(username);
                    comments.put(username,currentComments+1);
                    }else{
                        likes.put(username,0);
                        comments.put(username,1);
                    }
                    break;
                case "Blocked":
                    if(likes.containsKey(username)){
                        likes.remove(username);
                        comments.remove(username);
                    }else{
                        System.out.printf("%s doesn't exist.%n",username);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("%d followers%n",likes.size());
        likes.entrySet().forEach(entry->{
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue()+comments.get(entry.getKey()));
        });
    }
}
