package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private final ArrayList<Card> deck = new ArrayList();

    //Creates deck and automatically shuffles the deck.
    public Deck() {
        fillDeck();
    }

    public void fillDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank value : Rank.values()) {
                this.deck.add(new Card(suit, value));
            }
        }
        shuffleDeck();
    }

    //Gets the amount of cards still left in the deck.
    public int reaminingCards() {
        return deck.size();
    }

    //Calls shuffle method to easily shuffle the deck of cards
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    //grabs card to transport it to hand and deletes it from the deck.
    public Card dealCard() {
        Card cardToDeal;

        //grab card to remove
        cardToDeal = deck.get(0);

        //remove the card and send it back
        deck.remove(0);
        return cardToDeal;
    }

    @Override
    public String toString() {
        String deckcardsstr = "";
        for (Card deckCard : deck) {
            deckcardsstr += deckCard.toString();
        }
        return deckcardsstr;
    }
}
