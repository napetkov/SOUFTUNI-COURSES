package MapsLambdaAndStreamAPI.MoreExercises;

import java.util.*;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestMap = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> studentsMap = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];
            contestMap.put(contest, password);
            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("end of submissions")) {
            String contest = input2.split("=>")[0];
            String password = input2.split("=>")[1];
            String student = input2.split("=>")[2];
            int points = Integer.parseInt(input2.split("=>")[3]);

            if (isValidContest(contestMap, contest, password)) {
                if (!studentsMap.containsKey(student)) {
                    studentsMap.put(student, new HashMap<>());
                    studentsMap.get(student).put(contest, points);
                } else {// проверка за "contest"
                    if (studentsMap.get(student).containsKey(contest)) {
                        //currant points<=points - тогава презапиши точки
                        int currentPoint = studentsMap.get(student).get(contest);
                        if (currentPoint <= points) {
                            studentsMap.get(student).put(contest, points);
                        }
                    } else {
                        studentsMap.get(student).put(contest, points);
                    }
                }
            }
            input2 = scanner.nextLine();
        }
            //да се намери най-добър кандидат
            int maxPoint = Integer.MIN_VALUE;
            String maxCandidate = null;

        for (Map.Entry<String, Map<String, Integer>> entry : studentsMap.entrySet()) {
            int sumPoints = 0;
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                sumPoints+=integerEntry.getValue();
            }
            if(sumPoints>=maxPoint){
                maxPoint=sumPoints;
                maxCandidate= entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n",maxCandidate,maxPoint);
        System.out.println("Ranking:");
        studentsMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(element-> {
                System.out.printf("#  %s -> %d%n",element.getKey(),element.getValue());
            });
        });

    }

    private static boolean isValidContest(Map<String, String> contestMap, String contest, String password) {
        return contestMap.containsKey(contest) && contestMap.get(contest).equals(password);


    }
}
