package blackjack;

//Gives name of card as value assinged for calulations later in form of integer
public enum Rank {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    //For blackjack: Ten,Jack,Queen,King all share the same value;
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    //declare a rank value
    public final int Value;

    //sets a rank value for cards
    Rank(int r) {
        Value = r;
    }

}
