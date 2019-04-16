package blackjack;

import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList();
    }

    //Add Card to hand from Deck
    public void addCard(Card card) {
        if (card != null) {
            hand.add(card);
        } else {
            System.out.println("Can't add anymore cards");
        }
    }

    //Remove all cards from hand after turn is over
    public void removeCards() {
        hand.removeAll(hand);
    }

    //Gives total amount of cards in a hand
    public int getHandSize() {
        return hand.size();
    }

    public String toString() {
        String handNames = "";
        for (Card handCard : hand) {
            handNames += handCard.toString();
        }
        return handNames;
    }

    //Calculate Total Value of Hand
    public int getHandValue() {
        int val = 0;
        boolean ace = false;
        for (Card handCard : hand) {

            //increase value of hand to match card
            val += handCard.getValue();

            //Checking if Card is an Ace
            if (handCard.getValue() == 1) {
                ace = true;
            }
        }

        //Declaring if ace should be used as 11 or not. 
        if (ace == true && val + 10 <= 21) {
            val += 10;
        }

        return val;
    }

}