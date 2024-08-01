import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 5; 
    private static final int RANGE_MIN = 1;    
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int totalWins = 0;
        boolean playAgain = true;

        while (playAgain) {
            totalRounds++;
            int numberToGuess = generateRandomNumber(RANGE_MIN, RANGE_MAX);
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ":");

            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                System.out.print("Attempt " + attempt + ": ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    guessedCorrectly = true;
                    totalWins++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Wins: " + totalWins);
        System.out.println("Score: " + totalWins + "/" + totalRounds);

        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}