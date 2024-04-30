package com.cipherbytetech;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static int MIN_RANGE = 1;
    public static int MAX_RANGE = 100;
    public static int MAX_ATTEMPTS = 10;
    public static int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc= new Scanner(System.in);
        int totalScore = 0;

        System.out.println("WELCOME TO NUMBER GUESSING GAME\n");
        System.out.println("Total Number of Rounds: 3");
        System.out.println("No of Attempts for each round are 6\n");

        for(int i=1; i<=MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
            int currentAttempts = 0;
            System.out.println("Current Round: " + i + ": Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + " in " + MAX_ATTEMPTS + " attempts.\n");

            while(currentAttempts < MAX_ATTEMPTS) {
                System.out.println("Enter your Guess: ");
                int guessNumber = sc.nextInt();
                currentAttempts = currentAttempts + 1;

                if(guessNumber == number) {
                    int score = MAX_ATTEMPTS - currentAttempts;
                    totalScore += score;
                    System.out.println("Congrats! You successfully guessed the number. Attempts: " + currentAttempts + ". Round score: " + score);
                    break;
                }
                else if(guessNumber < number){
                    System.out.println("The number is greater than that " + guessNumber + ". Attempts Left = " + (MAX_ATTEMPTS - currentAttempts) + "\n");
                }
                else if(guessNumber > number){
                    System.out.println("The number is less than that " + guessNumber + ". Attempts Left = " + (MAX_ATTEMPTS - currentAttempts) + "\n");
                }
            }

            if(currentAttempts == MAX_ATTEMPTS) {
                System.out.println("You lost in the Round = " + i + ". Attempts = 0");
                System.out.println("The Random number is " + number + "\n");
            }
        }

        System.out.println("Game Over. Total Score = " + totalScore);
        sc.close();
    }
}
