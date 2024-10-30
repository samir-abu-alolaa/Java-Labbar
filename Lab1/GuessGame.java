import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        int answer = creatNr();
        System.out.println("Welcome to the game of \"Guess the Number\". Guess a number between 1 and 100.");
        guessing(answer); // Pass the random number to the guessing method
    }

    public static int creatNr(){
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    public static void guessing(int answer){
        Scanner scanner = new Scanner(System.in);

        for(int i = 1; i <= 6; i++){
            System.out.print("Your guess: ");
            String guess = scanner.nextLine();

            if (guess.equals("Cheat")) {
                System.out.println("Ah, you like cheating? The number is: " + answer);
                i--;
                continue;
            }

            if(checkString(guess, answer)){
                System.out.println("Correct!!! You win!!!");
                scanner.close();
                return;
            } else {
                System.out.println("Attempt " + i + " of 6.");
            }
        }
        
        System.out.println("You lose. The correct number was " + answer + ".");
        scanner.close();
    }

    public static boolean checkString(String arg, int answer){
        int guessNumber = 0;
        try {
            guessNumber = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, please enter a valid number.");
            return false;
        }

        if (guessNumber == answer) {
            return true;
        } else if (guessNumber < answer) {
            System.out.println("Too low.");
        } else {
            System.out.println("Too high.");
        }
        return false;
    }
}
