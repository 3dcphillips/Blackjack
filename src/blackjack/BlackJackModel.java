package blackjack;

class BlackJackModel {

    //Setup for the Game
    private final Deck gamedeck = new Deck();
    private final Hand playerHand = new Hand();
    private final Hand dealerHand = new Hand();
    private final Player player = new Player("You", playerHand);
    private final Dealer dealer = new Dealer("Dealer", dealerHand);
    private final int BLACKJACK = 21;
    boolean isDealersTurnOver = false;
    boolean isPlayersTurnOver = false;

    public BlackJackModel() {
    }

    //Calls method to give players cards.
    public void startGame() {
        dealStartingCards();
    }

    //Controls how long the dealer should hit for
    public String dealersTurn() {
        isPlayersTurnOver = true;
        int hitCounter = -1;
        while (dealer.getHandValue() < 17) {
            dealerHitCard();
            hitCounter++;
        }
        isDealersTurnOver = true;
        return "The Dealer hit " + hitCounter + " times\n";
    }

    //Checks to see if both turns are over. Then highest hand below blackjack wins.
    public String getWinner() {
        if (isPlayersTurnOver == true && isDealersTurnOver == true) {
            return compareValues();
        } else {
            return ("");
        }
    }

    //TODO
    public String compareValues() {
        if (playerHand.getHandValue() > dealerHand.getHandValue()) {
            resetGame();
            return ("\nThe Player Wins the Hand!\n");
        } else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
            resetGame();
            return ("\nThe Dealer Wins the Hand!\n");
        }
        resetGame();
        return ("\nThe Dealer and Player Tie\n");
    }

    public String checkBJorBust() {
        if (playerHand.getHandValue() == BLACKJACK) {
            resetGame();
            return ("\nThe Player wins the hand with Blackjack!!\n");
        } else if (dealerHand.getHandValue() == BLACKJACK) {
            resetGame();
            return ("\nThe Dealer wins the hand with Blackjack!\n");
        } else if (playerHand.getHandValue() > BLACKJACK) {
            resetGame();
            return ("\nPlayer Busts! Dealer wins the Hand!\n");
        } else if (dealerHand.getHandValue() > BLACKJACK) {
            resetGame();
            return ("\nDealer Busts! Player wins the Hand!\n");
        } else {
            return ("\nNo Blackjacks or Busts\n");
        }
    }

    public void dealStartingCards() {
        playerHitCard();
        playerHitCard();
        dealerHitCard();
    }

    //TODO
    public void resetGame() {
        isPlayersTurnOver = false;
        isDealersTurnOver = false;
        playerHand.removeCards();
        dealerHand.removeCards();
    }

    public String playerShowHand() {
        return playerHand.toString();
    }

    public String dealerShowHand() {
        return dealerHand.toString();
    }

    public int playerGetScore() {
        return playerHand.getHandValue();
    }

    public int dealerGetScore() {
        return dealerHand.getHandValue();
    }

    public void playerHitCard() {
        playerHand.addCard(gamedeck.dealCard());
    }

    public void dealerHitCard() {
        dealerHand.addCard(gamedeck.dealCard());
    }

    public Deck getGameDeck() {
        return gamedeck;
    }

    public void checkDeck() {
        if (getGameDeck().reaminingCards() < 1) {
            getGameDeck().fillDeck();
        }
    }

    public boolean getisDealersTurnOver() {
        return isDealersTurnOver;
    }

    public boolean getIsPlayersTurnOver() {
        return isPlayersTurnOver;
    }

}
