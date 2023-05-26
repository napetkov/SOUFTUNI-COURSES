import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }
    public void addExercise(Exercise exercise){
        if(this.exerciseCount>this.exercises.size()){
            this.exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name,String muscle){
        return exercises.removeIf((n)-> n.getName().equals(name)&&n.getMuscle().equals(muscle));
    }
    public Exercise getExercise(String name,String muscle){
        return exercises.stream().filter(exercise -> exercise.getName()
                .equals(name)&&exercise.getMuscle().equals(muscle)).findAny().orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise(){
        return exercises.stream().max((f,s)->Integer.compare(f.getBurnedCalories(),s.getBurnedCalories())).orElse(null);
    }
    public int getExerciseCount(){
           return exercises.size();
    }

    public String getType() {
        return type;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(getType()).append(System.lineSeparator());
        exercises.forEach(exercise -> {
            sb.append(String.format("Exercise: %s%n",exercise.toString()));
        });

        return sb.toString();
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }
}
