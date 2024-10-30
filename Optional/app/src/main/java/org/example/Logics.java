package org.example;

import java.util.List;

public class Logics {
    public static boolean stand() {
        return false;
    }

    public static boolean hit() {
        return true;
    }

    public static int countHand(List<String> hand) {
        int sum = 0;
        int aceCount = 0;  // Track how many aces are in the hand

            for (String card : hand) {
                String[] parts = card.split(" ");
                String rank = parts[1];

                int value = Card.getCardValue(rank);

                if (rank.equals("ACE")) {
                    aceCount++;  // Keep track of Aces
                }
                
                sum += value;  // Add card value to sum
            }

        // Adjust for Ace values
        while (aceCount > 0 && sum + 10 <= 21) {
            sum += 10;  // Convert Ace from 1 to 11 if it helps the hand
            aceCount--;  // Decrease ace count as one Ace has been considered as 11
        }

        return sum;
    }
}
