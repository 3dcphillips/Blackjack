//Daniel Phillips dcp21@psu.edu
//Deliverable 3
package blackjack;

public class App {

    public static void main(String[] args) {
        //Declare instance of Model
        BlackJackModel bjModel = new BlackJackModel();

        //Declare instance of the main BlackJack game view;
        BlackJackView bjView = new BlackJackView(bjModel);

        //Declare instance of Controller
        BlackJackController bjContoller = new BlackJackController(bjModel, bjView);
    }

}
