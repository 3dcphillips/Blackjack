package blackjack;

import java.awt.event.*;

class BlackJackController {

    private final BlackJackView bjView;
    private final BlackJackModel bjModel;

    public BlackJackController(BlackJackModel bjmodel, BlackJackView bjview) {
        this.bjModel = bjmodel;
        this.bjView = bjview;

        class PlayButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Button enable/disable Controls
                bjview.enableHitStayBtns();

                //Check if Deck has cards, if not refill Deck
                bjmodel.checkDeck();

                //Call model to create a new game
                bjview.updateConsole("\n--------------------\nBlackjack has started!\n");

                //Deal 2 Cards to each player
                bjmodel.startGame();

                //Showing Hands
                bjview.updateConsole("\nPlayers Hand Showing:\n");
                bjview.updateConsole(bjmodel.playerShowHand());
                bjview.updateConsole("\nDealers Hand Showing:\n");
                bjview.updateConsole(bjmodel.dealerShowHand());

                //Update Score
                bjview.updateDealerScore("Dealer Score: " + bjmodel.dealerGetScore());
                bjview.updatePlayerScore("Player Score: " + bjmodel.playerGetScore());

                //Check for BJ
                bjview.updateConsole(bjmodel.checkBJorBust());

            }
        }

        //Hit Button Controls
        class HitButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Check if Deck has cards, if not refill Deck
                bjmodel.checkDeck();

                //Give Player Card
                bjview.updateConsole("\nThe Player Hits!\n");
                bjmodel.playerHitCard();

                //Showing Hands
                bjview.updateConsole("\nPlayers Hand Showing:\n");
                bjview.updateConsole(bjmodel.playerShowHand());

                //Update Score
                bjview.updateDealerScore("Dealer Score: " + bjmodel.dealerGetScore());
                bjview.updatePlayerScore("Player Score: " + bjmodel.playerGetScore());

                //Check for BJ or Bust
                bjview.updateConsole(bjmodel.checkBJorBust());

                //Update Game with players turn
                bjview.updateConsole(bjmodel.getWinner());
            }

        }

        //Stay Button Controls
        class StayButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                //Check if Deck has cards, if not refill Deck
                bjmodel.checkDeck();

                //Update Console 
                bjview.updateConsole("\nThe Player Stays.\n");
                bjview.updateConsole("\nNow The Dealers Turn\n");

                //Update Game with dealers turn.
                bjview.updateConsole(bjmodel.dealersTurn());

                //Update Score
                bjview.updateDealerScore("Dealer Score: " + bjmodel.dealerGetScore());
                bjview.updatePlayerScore("Player Score: " + bjmodel.playerGetScore());

                //Showing Dealer Hand
                bjview.updateConsole("\nDealers Hand Showing:\n");
                bjview.updateConsole(bjmodel.dealerShowHand());

                //Check for 21 bust or win.
                bjview.updateConsole(bjmodel.checkBJorBust());

                //Check for winner
                bjview.updateConsole(bjmodel.getWinner());

            }

        }

        //Exit Button Controls
        class ExitButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                System.out.println("Closed");
            }

        }

        //Adding button listeners
        bjview.addPlayButtonListener(new PlayButtonListener());
        bjview.addHitButtonListener(new HitButtonListener());
        bjview.addStayButtonListener(new StayButtonListener());
        bjview.addExitButtonListener(new ExitButtonListener());
    }

}
