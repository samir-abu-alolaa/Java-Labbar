package Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {

    public enum Suits {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Ranks {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    public static List<String> createDeck() {
        List<String> deck = new ArrayList<>();

        for (Suits suit : Suits.values()) {
            for (Ranks rank : Ranks.values()) {
                deck.add(suit + " " + rank);  
                System.out.println(suit + " " + rank);  
            }
        }
        return deck;  // Return the list of cards
    }
    public static List<String> shuffleDeck(List<String> deck){
        Random rand = new Random();
        
        for (int i = 0; i < deck.size(); i++) {
            int randomIndex = rand.nextInt(deck.size());

            // Swap the elements
            String temp = deck.get(randomIndex); // Store value at randomIndex
            deck.set(randomIndex, deck.get(i));  // Set value at randomIndex to the value at i
            deck.set(i, temp);                   // Set value at i to the stored temp value
        }
        System.out.println(deck);
        return deck;
    }

    public static void showFirstAndLastCard(List<String> deck){
        List<String> firstAndLast = new ArrayList<>(); 
        String temp = deck.get(0);
        firstAndLast.add(temp);
        temp = deck.get((deck.size()-1));
        firstAndLast.add(temp);
        System.out.println(firstAndLast);
        }
    public static List<String> dealFirstCard(List<String> deck){
        String card = deck.get(0);
        deck.remove(0);
        System.out.println(card);
        return deck;
    }
    public static List<String> dealFiveCards(List<String> deck){
        List<String> fiveCard = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            fiveCard.add(deck.get(i));
            deck.remove(i);
        }
        System.out.println(fiveCard);
        return deck;
    }
    public static List<String> dealTwoCards(List<String> deck) {
        List<String> twoCards = new ArrayList<>();
        int sum1 = 0; // Sum considering Ace as 1
        int sum2 = 0; // Sum considering Ace as 14
        int aceCount = 0;
    
        // Deal two cards and remove them from the deck
        for (int i = 0; i < 2; i++) {
            String dealtCard = deck.get(0); // Get the top card (index 0)
            twoCards.add(dealtCard); // Add the dealt card to the twoCards list
            deck.remove(0); // Remove the top card from the deck
        }
    
        // Calculate the sums and handle Aces
        for (String card : twoCards) {
            String[] cardParts = card.split(" "); // Split by space to get the rank
            String rank = cardParts[1]; // Get the rank (second part)
    
            if (rank.equals("ACE")) {
                aceCount++;
            }
            sum1 += getCardValue(rank); // Basic sum (Ace as 1)
        }
    
        if (aceCount > 0) {
            sum2 = sum1 + (13 * aceCount); // Adjust for Ace being 14
        }
    
        // Print dealt cards and their sum
        System.out.println("Dealt two cards: " + twoCards);
        if (aceCount > 0) {
            System.out.println("With sum: " + sum1 + " or " + sum2);
        } else {
            System.out.println("With sum: " + sum1);
        }
    
        return deck;
    }
    
    
    
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

    public static int deckCount(List<String> deck){
        int count = 0;
        for (String string : deck) {
            count++;
        }
        System.out.println("The amount of cards remaining is :" + count);
        return count;
    }
}