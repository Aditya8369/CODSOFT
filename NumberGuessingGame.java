/* 
 Created by Aditya Mahajan from SE computer engineering at PVPIT
Problem statement:- Create a java program for number guessing.
  1.Generate a random number within a specified range such as 1 to 100
  2.Prompt the user to enter their guess for the generated number
  3.Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high or too low
  4.Repeat steps 2 and 3 until the user guesses the correct answer
  */
  
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Create a Random object to generate a random number
        Random random = new Random();

        // Define the lower and upper bounds for the range of numbers
        int lowerBound = 1;
        int upperBound = 100;

        // Generate a random number within the specified range
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1);
        int attempts = 0;
        int maxAttempts = 10;
         System.out .println("Welcome to the Number Guessing Game!");
         System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

         while (attempts < maxAttempts){
             System.out.print("Enter your Guess Number: ");
             int userGuess = sc.nextInt();
             attempts++;

             if(userGuess == numberToGuess) {
                 System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                 break;
             }
             else if(userGuess < numberToGuess){
                 System.out.println("Try a higher number.");
             }
             else{
                 System.out.println("Try a lower number.");
             }
         }
         if(attempts == maxAttempts){
             System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + numberToGuess);
         }
         System.out.println("Thanks for playing!");
    }
}
