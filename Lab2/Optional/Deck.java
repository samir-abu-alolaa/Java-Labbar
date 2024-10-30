package Optional;

import java.util.List;

public class Deck {

    public static void main(String[] args) {
        List<String> deck = Card.createDeck();
        //System.out.println("The amount of cards in the deck is: " + Card.deckCount(deck));

        List<String> shuffledDeck = Card.shuffleDeck(deck); // Shuffle the deck
        //System.out.println("Deck shuffled.");

        Card.showFirstAndLastCard(shuffledDeck); // Show first and last card

        List<String> deckWithoutFirst = Card.dealFirstCard(shuffledDeck); // Deal first card
        //System.out.println("First card dealt. Remaining deck size: " + Card.deckCount(deckWithoutFirst));

        List<String> deckWithoutFiveCards = Card.dealFiveCards(deckWithoutFirst); // Deal 5 cards
        //System.out.println("Five cards dealt. Remaining deck size: " + Card.deckCount(deckWithoutFiveCards));

        List<String> deckAfterTwoCards = Card.dealTwoCards(deckWithoutFiveCards); // Deal 2 cards
        //System.out.println("Two cards dealt. Remaining deck size: " + Card.deckCount(deckAfterTwoCards));
    }
}