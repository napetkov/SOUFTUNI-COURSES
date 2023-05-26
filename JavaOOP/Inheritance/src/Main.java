public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        randomArrayList.add(7);
        randomArrayList.add(18);
        randomArrayList.add(21);
        randomArrayList.add(18);

        System.out.println(randomArrayList.getRandomElement());
    }
}
