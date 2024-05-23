import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 50;
        int attemptsLimit = 5;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess any number between " + minRange + " and " + maxRange + ".");
        
        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("A random number has been generated. You only have " + attemptsLimit + " attempts.");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter the number you have guessed: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("The number is too low! Try again.");
                } else {
                    System.out.println("The number is too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, your total attempt is over. The correct number was: " + generatedNumber);
            }
            
            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("ThankYou for playing!");
        scanner.close();
    }
}
