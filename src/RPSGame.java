import java.util.Scanner;
import java.util.Random;

public class RPSGame {

    /**
     * Main method
     */
    public static void main(String[] args) {

        //Declare and initialize the variables
        String result, userChoiceText, pcChoiceText;
        int userChoice, pcChoice, userScore, pcScore;
        userScore = pcScore = 0;

        //Call the required classes
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("*****************************************");
        System.out.println("Welcome to the rock-paper-scissors game!");

        //Continue the game until one of players reach the 5 score
        while (userScore < 5 && pcScore < 5) {

            //Create a simple user interface
            System.out.println("*****************************************");
            System.out.println("Your Score: " + userScore + " - My Score: " + pcScore);
            System.out.println("1 - Rock");
            System.out.println("2 - Paper");
            System.out.println("3 - Scissors");
            System.out.print("Please enter your choice: ");

            //Get the user's choice
            userChoice = input.nextInt();

            //If the user's choice is invalid, ask again
            while (userChoice != 1 && userChoice != 2 && userChoice != 3) {
                System.out.print("Invalid choice! Please enter your choice: ");
                userChoice = input.nextInt();
            }

            //Generate a random value from 1,2,3 for computer's choice
            pcChoice = rand.nextInt(3) + 1;

            //Choose the winner and update the scores
            if (userChoice == pcChoice) {
                result = "Deuce";
            } else if (userChoice == 1) {
                if (pcChoice == 2) {
                    pcScore++;
                    result = "You lost";
                } else {
                    userScore++;
                    result = "You won";
                }
            } else if (userChoice == 2) {
                if (pcChoice == 3) {
                    pcScore++;
                    result = "You lost";
                } else {
                    userScore++;
                    result = "You won";
                }
            } else {
                if (pcChoice == 1) {
                    pcScore++;
                    result = "You lost";
                } else {
                    userScore++;
                    result = "You won";
                }
            }

            //Convert number to text for easy-reading
            userChoiceText = getChoiceText(userChoice);
            pcChoiceText = getChoiceText(pcChoice);

            //Print the round result
            System.out.println("\nYour Choice: " + userChoice + ": " + userChoiceText + " - My Choice: " + pcChoice + ": " + pcChoiceText);
            System.out.println(result + "!\n");
        }

        //Print the game result
        System.out.println("*****************************************");
        System.out.println("Your Score: " + userScore + " - My Score: " + pcScore);
        if (pcScore < userScore) {
            System.out.println("Game over! You won.");
        } else {
            System.out.println("Game over! I won.");
        }
        System.out.println("*****************************************");

    }

    /**
     * Convert number to text
     */
    private static String getChoiceText(int choice) {
        String result;
        switch (choice) {
            case 1:
                result = "Rock";
                break;
            case 2:
                result = "Paper";
                break;
            case 3:
                result = "Scissors";
                break;
            default:
                result = null;
        }
        return result;
    }

}
