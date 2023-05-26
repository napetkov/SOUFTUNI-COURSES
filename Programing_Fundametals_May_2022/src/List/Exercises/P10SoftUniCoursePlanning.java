package List.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> scheduleOfLessons = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            List<String> commandList = Arrays.stream(input.split(":"))
                    .collect(Collectors.toList());
            String command = commandList.get(0);
            String lessonTitle = commandList.get(1);
            switch (command) {
                case "Add":
                    if (!scheduleOfLessons.contains(lessonTitle)) {
                        scheduleOfLessons.add(lessonTitle);
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(commandList.get(2));

                    if (!scheduleOfLessons.contains(lessonTitle)) {
                        scheduleOfLessons.add(index, lessonTitle);
                    }
                    break;

                case "Remove":
                    if (scheduleOfLessons.contains(lessonTitle)) {
                        scheduleOfLessons.remove(lessonTitle);
                    }
                    int lesson1Index = scheduleOfLessons.indexOf(lessonTitle);

                    if (scheduleOfLessons.get(lesson1Index + 1).equals(lessonTitle + "-Exercise")) {
                        scheduleOfLessons.remove(lesson1Index + 1);
                    }
                    break;

                case "Swap":
                    String secondLessonTitle = commandList.get(2);

                    if (scheduleOfLessons.contains(lessonTitle) && scheduleOfLessons.contains(secondLessonTitle)) {
                        lesson1Index = scheduleOfLessons.indexOf(lessonTitle);
                        int lesson2Index = scheduleOfLessons.indexOf(secondLessonTitle);

                        String exOne = lessonTitle + "-Exercise";
                        String exTwo = secondLessonTitle + "-Exercise";

                        scheduleOfLessons.set(lesson1Index, secondLessonTitle);
                        scheduleOfLessons.set(lesson2Index, lessonTitle);

                        if (scheduleOfLessons.contains(exOne)) {

                            scheduleOfLessons.remove(scheduleOfLessons.indexOf(exOne));
                            scheduleOfLessons.add(scheduleOfLessons.indexOf(lessonTitle) + 1, exOne);
                        }
                        if (scheduleOfLessons.contains(exTwo)) {

                            scheduleOfLessons.remove(scheduleOfLessons.indexOf(exTwo));
                            scheduleOfLessons.add(scheduleOfLessons.indexOf(secondLessonTitle) + 1, exTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String exercise= lessonTitle +"-Exercise";
                    int indexLessonTitle = scheduleOfLessons.indexOf(lessonTitle);

                    if (scheduleOfLessons.contains(lessonTitle)) {
                        if (indexLessonTitle==scheduleOfLessons.size()-1){
                            scheduleOfLessons.add(indexLessonTitle+1,exercise);
                        }else if (!scheduleOfLessons.get(indexLessonTitle+1).equals(exercise)) {
                            scheduleOfLessons.add(indexLessonTitle+1,exercise);
                        }
                    } else {
                        scheduleOfLessons.add(lessonTitle);
                        scheduleOfLessons.add(exercise);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        printList(scheduleOfLessons);

    }

    private static void printList(List<String> scheduleOfLessons) {
        for (int i = 0; i < scheduleOfLessons.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, scheduleOfLessons.get(i));

        }


    }

}
