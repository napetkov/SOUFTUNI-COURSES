package FinalExamParparation.Parparation27July2022;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,String> pieceComposer = new LinkedHashMap<>();
        Map<String,String> pieceKey = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            pieceComposer.put(piece,composer);
            pieceKey.put(piece,key);
        }
        String commandLine = scanner.nextLine();
        while(!commandLine.equals("Stop")){
            String command = commandLine.split("\\|")[0];
            String currentPiece = commandLine.split("\\|")[1];
            if(command.equals("Add")){
                if(pieceComposer.containsKey(currentPiece)){
                    System.out.printf("%s is already in the collection!%n",currentPiece);
                }else{
                    pieceComposer.put(currentPiece,commandLine.split("\\|")[2]);
                    pieceKey.put(currentPiece,commandLine.split("\\|")[3]);
                    System.out.printf("%s by %s in %s added to the collection!%n",currentPiece,pieceComposer.get(currentPiece),pieceKey.get(currentPiece));
                }
            }else if(command.equals("Remove")){
                if(pieceComposer.containsKey(currentPiece)){
                    pieceComposer.remove(currentPiece);
                    pieceKey.remove(currentPiece);
                    System.out.printf("Successfully removed %s!%n",currentPiece);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",currentPiece);
                }
            }else if(command.equals("ChangeKey")){
                if(pieceComposer.containsKey(currentPiece)){
                    pieceKey.put(currentPiece,commandLine.split("\\|")[2]);
                    System.out.printf("Changed the key of %s to %s!%n",currentPiece,commandLine.split("\\|")[2]);
                }else{
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",currentPiece);
                }
            }

            commandLine= scanner.nextLine();
        }
          pieceComposer.entrySet().forEach(entry->{
              System.out.printf("%s -> Composer: %s, Key: %s%n",entry.getKey(),entry.getValue(),pieceKey.get(entry.getKey()));
          });




    }
}
