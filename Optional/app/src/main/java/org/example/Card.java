package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;

public class Card {

    public enum Suits {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Ranks {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    // Create a new deck of cards
    public static List<String> createDeck() {
        List<String> deck = new ArrayList<>();

        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                deck.add(suit + " " + rank);  
            }
        }
        return deck;
    }

    // Shuffle the deck using Fisher-Yates shuffle algorithm
    public static List<String> shuffleDeck(List<String> deck) {
        Random rand = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int randomIndex = rand.nextInt(i + 1);
            String temp = deck.get(randomIndex);
            deck.set(randomIndex, deck.get(i));
            deck.set(i, temp);
        }
        return deck;
    }

    // Deal a specified number of cards from the deck
    public static List<String> dealCards(List<String> deck, int numberOfCards) {
        List<String> dealtCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            dealtCards.add(deck.remove(0));
        }
        return dealtCards; // Return only the dealt cards
    }

    // Get the value of a card based on its rank
    public static int getCardValue(String rank) {
        switch (rank) {
            case "ACE": return 1;
            case "TWO": return 2;
            case "THREE": return 3;
            case "FOUR": return 4;
            case "FIVE": return 5;
            case "SIX": return 6;
            case "SEVEN": return 7;
            case "EIGHT": return 8;
            case "NINE": return 9;
            case "TEN": return 10;
            case "JACK": case "QUEEN": case "KING": return 10;
            default: throw new IllegalArgumentException("Unknown rank: " + rank);
        }
    }
    public static void printHand(List<String> hand, String owner) {
        System.out.println(owner + "'s hand:");

        // Prepare the top, middle, and bottom parts of the graphical card representation
        String top = "";
        String middle = "";
        String bottom = "";

        for (String card : hand) {
            String[] parts = card.split(" ");
            String suit = parts[0];
            String rank = parts[1];

            // Convert the suit and rank to a graphical representation
            String suitSymbol = getSuitSymbol(suit);
            String rankFormatted = getFormattedRank(rank);

            // Build graphical representation of the card
            top += "┌─────────┐ ";
            middle += "│ " + rankFormatted + suitSymbol + "     │ ";
            bottom += "└─────────┘ ";
        }

        // Print the assembled hand row by row
        System.out.println(top);
        System.out.println(middle);
        System.out.println(bottom);
    }

    // Method to get the suit symbol
    private static String getSuitSymbol(String suit) {
        switch (suit) {
            case "CLUBS":
                return "♣";
            case "DIAMONDS":
                return "♦";
            case "HEARTS":
                return "♥";
            case "SPADES":
                return "♠";
            default:
                return "?";  // In case there's an unknown suit
        }
    }

    // Method to format the rank for consistent card size display
    private static String getFormattedRank(String rank) {
        switch (rank) {
            case "ACE":
                return "A ";
            case "TWO":
                return "2 ";
            case "THREE":
                return "3 ";
            case "FOUR":
                return "4 ";
            case "FIVE":
                return "5 ";
            case "SIX":
                return "6 ";
            case "SEVEN":
                return "7 ";
            case "EIGHT":
                return "8 ";
            case "NINE":
                return "9 ";
            case "TEN":
                return "10";
            case "JACK":
                return "J ";
            case "QUEEN":
                return "Q ";
            case "KING":
                return "K ";
            default:
                return "? ";  // In case of an unknown rank
        }
    }
}
