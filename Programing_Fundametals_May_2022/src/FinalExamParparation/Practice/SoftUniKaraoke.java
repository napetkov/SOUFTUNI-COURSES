package FinalExamParparation.Practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Map.Entry.comparingByValue;

public class SoftUniKaraoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participant = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        List<String> songs = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        Map<String, List<String>> awardsMap = new TreeMap<>();


        while (!input.equals("dawn")) {
            String currentParticipant = input.split(",\\s+")[0];
            String currentSong = input.split(",\\s+")[1];
            String award = input.split(",\\s+")[2];

            if (isValidAward(currentParticipant, currentSong, participant, songs)) {

                if (awardsMap.containsKey(currentParticipant)) {
                    List<String> currentAwardList = new ArrayList<>(awardsMap.get(currentParticipant));
                    if (!currentAwardList.contains(award)) {
                        currentAwardList.add(award);
                    }
                    awardsMap.put(currentParticipant, currentAwardList);

                } else {
                    awardsMap.put(currentParticipant, new ArrayList<>());
                    awardsMap.get(currentParticipant).add(award);
                }

            }
            input = scanner.nextLine();
        }
        Map<String, Integer> countAwards = new TreeMap<>();
        awardsMap.entrySet().forEach(entry -> {
            int count = entry.getValue().size();
            countAwards.put(entry.getKey(), count);
        });

        if (awardsMap.isEmpty()) {
            System.out.println("No awards");
        } else {
            List<String> awardList = countAwards.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(entry -> entry.getKey()).collect(Collectors.toList());

            for (String singer : awardList) {
                System.out.printf("%s: %d awards%n", singer, countAwards.get(singer));
                for (String award : awardsMap.get(singer).stream().sorted().collect(Collectors.toList())) {
                    System.out.printf("--%s%n", award);
                }
            }
        }
    }
    private static boolean isValidAward(String currentParticipant, String currentSong, List<String> participant, List<String> songs) {
        return participant.contains(currentParticipant) && songs.contains(currentSong);
    }
}
