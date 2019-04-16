package blackjack;

import java.util.ArrayList;

public class Dealer {

    private String name;
    private Hand hand;

    public Dealer(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public int getHandValue() {
        return hand.getHandValue();
    }
   

    public String showHand() {
        return hand.toString();
    }

    public String getName() {
        return name;
    }

    public void setHand(Hand ahand) {
        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

}
