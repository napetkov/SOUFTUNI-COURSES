package WhileLoop.MoreExercises;

public class NumbersDividedByThreeWithoutReminder {
    public static void main(String[] args) {
      int i=0;
        for (i = 1; i <= 100; i++) {
            if(i%3==0){
                System.out.println(i);
            }
        }
    }
}
