package blackjack;

import javax.swing.border.Border;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class BlackJackView extends JFrame {

    private final BlackJackModel bjModel;

    private final JPanel mainPanel;
    private final JScrollPane scrollPane;
    private final JTextArea console;
    private final JButton playButton;
    private final JButton hitButton;
    private final JButton stayButton;
    private final JButton exitButton;
    private final JLabel playerLabel;
    private final JLabel dealerLabel;

    BlackJackView(BlackJackModel bjModel) {
        this.bjModel = bjModel;

        //UI setup
        mainPanel = new JPanel();
        scrollPane = new JScrollPane();
        console = new JTextArea();
        playButton = new JButton();
        hitButton = new JButton();
        stayButton = new JButton();
        exitButton = new JButton();
        playerLabel = new JLabel();
        dealerLabel = new JLabel();

        //Start View without access to Hit and Stay Buttons
        disableHitStayBtns();

        //JFrame Setup
        JFrame mainFrame = new JFrame("Blackjack");
        mainFrame.setSize(700, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.getContentPane().add(mainPanel);

        //JPanel Setup
        mainPanel.setBackground(new java.awt.Color(24, 139, 24));
        mainPanel.setPreferredSize(new java.awt.Dimension(700, 500));
        mainPanel.setSize(new java.awt.Dimension(700, 500));
        mainPanel.setLayout(null);

        //BufferedImage
        //JTextArea Setup
        console.setColumns(20);
        console.setRows(5);
        scrollPane.setViewportView(console);

        //ScrollPane Setup
        mainPanel.add(scrollPane);
        scrollPane.setBounds(20, 280, 460, 200);

        //PlayButton Setup
        playButton.setText("Play New Game");
        mainPanel.add(playButton);
        playButton.setBounds(500, 20, 190, 60);

        //HitButton Setup
        hitButton.setText("Hit");
        mainPanel.add(hitButton);
        hitButton.setBounds(500, 280, 190, 60);

        //StayButton Setup
        stayButton.setText("Stay");
        mainPanel.add(stayButton);
        stayButton.setBounds(500, 350, 190, 60);

        //ExitButton Setup
        exitButton.setText("Exit");
        mainPanel.add(exitButton);
        exitButton.setBounds(500, 420, 190, 60);

        //PlayerLabel Setup
        playerLabel.setText("Player Score: ");
        mainPanel.add(playerLabel);
        playerLabel.setBounds(20, 20, 110, 50);
        Border PlayerLabelBoarder = BorderFactory.createLineBorder(Color.BLUE, 2);
        playerLabel.setBorder(PlayerLabelBoarder);

        //DealerLabel Setup
        dealerLabel.setText("Dealer Score: ");
        mainPanel.add(dealerLabel);
        dealerLabel.setBounds(300, 20, 110, 50);
        Border DealerLabelBoarder = BorderFactory.createLineBorder(Color.RED, 2);
        dealerLabel.setBorder(DealerLabelBoarder);

    }

    //Adding action listeners and action methods 
    public void addPlayButtonListener(ActionListener al) {
        playButton.addActionListener(al);
    }

    public void addHitButtonListener(ActionListener al) {
        hitButton.addActionListener(al);
    }

    public void addStayButtonListener(ActionListener al) {
        stayButton.addActionListener(al);
    }

    public void addExitButtonListener(ActionListener al) {
        exitButton.addActionListener(al);
    }

    //Displays output to console.
    public void updateConsole(String update) {
        console.append(update);
    }

    //todo
    public void updatePlayerScore(String update) {
        playerLabel.setText(update);
    }

    //todo
    public void updateDealerScore(String update) {
        dealerLabel.setText(update);
    }

    //Button Enable/Disable Methods.
    public void enableHitStayBtns() {
        stayButton.setEnabled(true);
        hitButton.setEnabled(true);
    }

    public void disableHitStayBtns() {
        stayButton.setEnabled(false);
        hitButton.setEnabled(false);
    }

    public void enablePlayBtn() {
        playButton.setEnabled(true);
    }

    public void disablePlayBtn() {
        playButton.setEnabled(false);
    }
}
