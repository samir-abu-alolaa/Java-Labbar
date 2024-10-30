package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    
    // Main method to run the blackjack game
    public static void main(String[] args) {
        List<String> deck = Card.createDeck();  // Call the createDeck method
        List<String> shuffledDeck = Card.shuffleDeck(deck); // Shuffle the deck

        System.out.println("Welcome to our simple Blackjack game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name and finish with enter:");
        String name = scanner.nextLine();

        int playerSum = 0;
        int pcSum = 0;

        // Deal two cards to the player initially
        List<String> playerHand = Card.dealCards(shuffledDeck, 2);
        int handCount = Logics.countHand(playerHand);
        playerSum += handCount;

        // Deal one card to the PC initially
        List<String> pcHand = Card.dealCards(shuffledDeck, 1);
        int pcHandCount = Logics.countHand(pcHand);
        pcSum += pcHandCount;

        // Print the player's hand graphically
        System.out.println("This is your hand: ");
        Card.printHand(playerHand , "Player");
        System.out.println("with a count of " + handCount);

        // Print the PC's initial card
        System.out.println("This is the PC's initial card: ");
        Card.printHand(pcHand, "PC");

        // Game loop: Allow player to hit or stand
        while (true) {
            System.out.println("Would you like to hit? Type 'y' for yes, or any other key to stand:");
            String choice = scanner.nextLine();
            if (choice.equals("y")) {
                // Deal one more card to the player
                List<String> extraCard = Card.dealCards(shuffledDeck, 1);
                playerHand.addAll(extraCard); // Add the new card to player's hand
                int newHandCount = Logics.countHand(playerHand);
                playerSum = newHandCount;

                // Print the new hand graphically
                System.out.println("You received: ");
                Card.printHand(extraCard, "Player");
                System.out.println("Your new hand is: ");
                Card.printHand(playerHand, "Player");
                System.out.println("with a count of " + newHandCount);

                // If player exceeds 21, they lose
                if (playerSum > 21) {
                    System.out.println("You bust! Your total is over 21.");
                    break;
                }
            } else {
                // Player stands, proceed with the PC's turn
                System.out.println("You chose to stand with a total of " + playerSum);
                System.out.println("Now it's the PC's turn.");
                break;
            }
        }

        // If the player has already busted, there's no need for the PC to play
        if (playerSum > 21) {
            System.out.println("PC wins as you have busted!");
            return;
        }

        // PC's turn: the PC will keep hitting until it reaches 17 or more
        while (pcSum < 17) {
            System.out.println("PC is drawing a card...");
            List<String> pcCard = Card.dealCards(shuffledDeck, 1);
            pcHand.addAll(pcCard);  // Add the card to PC's hand
            pcSum = Logics.countHand(pcHand);
            System.out.println("PC received: ");
            Card.printHand(pcCard, "PC");
            System.out.println("PC's hand is now: ");
            Card.printHand(pcHand, "PC");
            System.out.println("with a total of " + pcSum);

            // If PC busts (goes over 21), player wins
            if (pcSum > 21) {
                System.out.println("PC busts! PC's total is over 21. You win!");
                return;
            }
        }

        // After PC's turn, compare totals to determine the winner
        if (pcSum >= 17 && pcSum <= 21) {
            System.out.println("PC stands with a total of " + pcSum);
            if (pcSum > playerSum) {
                System.out.println("PC wins with a total of " + pcSum + " against your " + playerSum + ".");
            } else if (playerSum > pcSum) {
                System.out.println("You win with a total of " + playerSum + " against PC's " + pcSum + ".");
            } else {
                System.out.println("It's a tie! Both you and PC have " + playerSum + ".");
            }
        }

        scanner.close(); // Close the scanner to avoid resource leaks
    }  
}
