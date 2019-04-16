package blackjack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank value) {
        this.suit = suit;
        this.rank = value;
    }

    //Using The Map
    public final static Map<String, Card> CARDMAP = setCardMap();

    private static Map<String, Card> setCardMap() {
        final Map<String, Card> cards = new HashMap<>();
        for (final Suit suit : Suit.values()) {
            for (final Rank rank : Rank.values()) {
                cards.put(cardKey(suit, rank), new Card(suit, rank));
            }
        }
        return cards;
    }

    //Creating a key to access the card
    private static String cardKey(Suit suit, Rank rank) {
        return rank + " of " + suit;
    }

    //Gets the int value attached to Enum of Value
    public int getValue() {
        return rank.Value;
    }

    //Gets Suit value attached to Enum of Suit
    public Suit getSuit() {
        return suit;
    }

    //Return String of card
    @Override
    public String toString() {
        return rank + " of " + suit + " with a value of  "
                + rank.Value + "\n";
    }
}
