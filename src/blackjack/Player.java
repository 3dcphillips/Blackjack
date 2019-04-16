package blackjack;

public class Player {

    private String name;
    private Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHand(Hand ahand) {
        this.hand = ahand;
    }

    //gets value of hand;
    public int getHandValue() {
        return hand.getHandValue();
    }

    public String showHand() {
        return hand.toString();
    }

}