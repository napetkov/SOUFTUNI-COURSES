public class Main {
    public static void main(String[] args) {
// Initialize the repository
        Workout workout = new Workout("strength", 4);

        System.out.println(workout.getExercise("asd", "qwe"));
        System.out.println(workout.getExerciseCount());
        System.out.println(workout.removeExercise("asd", "qwe"));
        System.out.println(workout.getMostBurnedCaloriesExercise());
        System.out.println(workout.getExerciseCount());
        System.out.println(workout.getStatistics());

//// Initialize entity
//        Exercise exercise = new Exercise("Bench Press", "chest", 30);
//
//// Print Exercise
//        System.out.println(exercise); // Exercise: Bench Press, chest, 30
//
//// Add Exercise
//        workout.addExercise(exercise);
//
//// Remove Exercise
//        System.out.println(workout.removeExercise("Bench Press", "arms")); // false
//        System.out.println(workout.removeExercise("Bench Press", "chest")); // true
//
////Get exercise
//        System.out.println(workout.getExercise("Bench Press", "chest")); // null
//
//        Exercise secondExercise = new Exercise("Deadlift", "back", 50);
//        Exercise thirdExercise = new Exercise("Barbell Curl", "biceps", 25);
//        Exercise fourthExercise = new Exercise("Squats", "legs", 60);
//        Exercise fifthExercise = new Exercise("Deadlift", "legs", 55);
//        Exercise exercises = new Exercise("Test","test",70);
//
//        workout.addExercise(secondExercise);
//        workout.addExercise(thirdExercise);
//        workout.addExercise(exercises);
//        workout.addExercise(fifthExercise);
//
////Get mostBurnedCaloriesExercise
//        Exercise mostBurnedCaloriesExercise = workout.getMostBurnedCaloriesExercise();
//        System.out.println(mostBurnedCaloriesExercise); // Exercise: Squats, legs, 60
//
//        Exercise exerciseByNameAndMuscle = workout.getExercise("Deadlift", "back");
//        System.out.println(exerciseByNameAndMuscle); // Exercise: Deadlift, back, 50
//
//// Count
//        System.out.println(workout.getExerciseCount()); // 3
//        System.out.println(workout.removeExercise("Barbell Curl", "biceps")); // true
//
//// Print Statistics
//        System.out.println(workout.getStatistics());
//        System.out.println(workout.removeExercise("Squats", "koch"));
//
//
//        System.out.println(workout.getExercise("Deadlift","asd"));
////Workout type: strength
////Exercise: Deadlift, back, 50
//Exercise: Squats, legs, 60

    }
}
