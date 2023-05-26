package ExamPerparation;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberMovies = Integer.parseInt(scanner.nextLine());
        double sumRating = 0;
        double minRating = Double.MAX_VALUE;
        double maxRating = Double.MIN_VALUE;
        String maxRatingName = "";
        String minRatingName = "";
        for (int i = 0; i < numberMovies; i++) {
            String movieName = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());
            sumRating += rating;
            if(maxRating<rating){
                maxRating = rating;
            maxRatingName = movieName;
            }
            if(minRating>rating){
                minRatingName = movieName;
                minRating = rating;
            }
        }
        System.out.printf("%s is with highest rating: %.1f%n",maxRatingName,maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n",minRatingName,minRating);
        System.out.printf("Average rating: %.1f",sumRating/numberMovies);

    }
}
