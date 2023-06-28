import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int town_id = random.nextInt(32 + 1 - 1) + 1;

        System.out.println(town_id);
    }
}
