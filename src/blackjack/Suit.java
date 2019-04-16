package blackjack;

//Suits are not given ints becuase they don't need to be compared. Only the ranks do.
public enum Suit {
    Clubs("Clubs"),
    Diamonds("Diamonds"),
    Hearts("Hearts"),
    Spades("Spades");

    //declare a suit name for each suit
    private final String suitName;

    //sets suit value for cards
    private Suit(String suitName) {
        this.suitName = suitName;
    }

    //Useful for comparing values later
    public String PrintSuitName() {
        return suitName;
    }
}
