
package guessinggame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Marcos Rodriguez
 * Enhanced Number Guessing Game
 */
public class Guessinggame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the enhanced number guessing game!");

        int bestScore = Integer.MAX_VALUE; 
        boolean keepPlaying = true;

        while (keepPlaying) {
            int maxNumber = chooseDifficulty(input);

            int attemptsThisGame = playGame(input, 1, maxNumber);

            System.out.println("You guessed the number in " + attemptsThisGame + " attempts!");

            if (attemptsThisGame < bestScore) {
                bestScore = attemptsThisGame;
                System.out.println("New best score! Great job!");
            } else if (bestScore != Integer.MAX_VALUE) {
                System.out.println("Your best score so far is " + bestScore + " attempts.");
            }

            keepPlaying = askToPlayAgain(input);
        }

        System.out.println("Thanks for playing! Goodbye!");
        input.close();
    }


    /**
     * Lets the user select a difficulty level (1–3).
     * Returns the maximum number for the range.
     */
    private static int chooseDifficulty(Scanner input) {
        System.out.println();
        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy   (1 - 50)");
        System.out.println("2. Medium (1 - 100)");
        System.out.println("3. Hard   (1 - 500)");

        int choice = 0;

        while (choice < 1 || choice > 3) {
            System.out.print("Enter your choice (1, 2, or 3): ");
            choice = getValidInt(input);

            if (choice < 1 || choice > 3) {
                System.out.println("Please enter 1, 2, or 3.");
            }
        }

        switch (choice) {
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 500;
        }

        return 100; // fallback
    }


    /**
     * Plays one round of the guessing game.
     * Returns number of attempts.
     */
    private static int playGame(Scanner input, int min, int max) {

        int secretNum = (int) (Math.random() * max) + min;
        int attempts = 0;
        int guess = 0;

        System.out.println();
        System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
        System.out.println("Try to guess it!");

        while (guess != secretNum) {
            System.out.print("Enter your guess: ");
            guess = getValidInt(input);

            if (guess < min || guess > max) {
                System.out.println("Your guess must be between " + min + " and " + max + ".");
                continue;
            }

            attempts++;

            if (guess < secretNum) {
                System.out.println("Too low, try again.");
            } else if (guess > secretNum) {
                System.out.println("Too high, try again.");
            } else {
                System.out.println("Correct!");
            }
        }

        return attempts;
    }


    /**
     * Safely reads an integer with input validation.
     */
    private static int getValidInt(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid entry. Please enter a whole number: ");
                input.next(); // clear invalid token
            }
        }
    }


    /**
     * Asks the user if they want to play again.
     */
    private static boolean askToPlayAgain(Scanner input) {
        System.out.print("Would you like to play again? (y/n): ");
        String response = input.next().trim().toLowerCase();

        while (!response.equals("y") && !response.equals("n")) {
            System.out.print("Please enter 'y' or 'n': ");
            response = input.next().trim().toLowerCase();
        }

        return response.equals("y");
    }
}
