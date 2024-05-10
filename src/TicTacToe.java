import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random rand = new Random();

    JFrame frame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerXTurn;
    private int xWinCount = 0;
    private int yWinCount = 0;

    // constructor
    TicTacToe() {
        //frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,1000);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //text / title
        text.setBackground(Color.black);
        text.setForeground(Color.pink);
        text.setFont(new Font("TimesRoman", Font.BOLD, 100));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic Tac Toe");
        text.setOpaque(true);

        //main panel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(0,0,900, 100);
        mainPanel.add(text);
        frame.add(mainPanel,BorderLayout.NORTH);

        //game panel
        gamePanel.setLayout(new GridLayout(3,3));
        gamePanel.setBackground(Color.gray);
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            gamePanel.add(buttons[i]);
            buttons[i].setFont(new Font("TimesRoman", Font.BOLD, 300));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

            firstTurn();
        }
        frame.add(gamePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 9; i++) {

            if(e.getSource()==buttons[i]){
                if(playerXTurn) {
                    if(buttons[i].getText().equals("")) {

                        buttons[i].setForeground(Color.PINK);
                        buttons[i].setText("X");
                        playerXTurn = false;
                        text.setText("O Turn");
                        text.setForeground(Color.cyan);

                    }
                }
                else {
                    if(buttons[i].getText().equals("")) {

                        buttons[i].setForeground(Color.cyan);
                        buttons[i].setText("O");
                        playerXTurn = true;
                        text.setText("X Turn");
                        text.setForeground(Color.pink);

                    }

                }

            }
            checkWin();
        }

    }

    public void firstTurn() {

        if ((int)(Math.random()*2) == 1) {
            playerXTurn = true;
            text.setText("X Turn");
            text.setForeground(Color.pink);
        }
        else {

            playerXTurn = false;
            text.setText("O Turn");
            text.setForeground(Color.cyan);
        }

    }

    public void checkWin() {
        // x win conditions
        if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0,1,2);
        }
        if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3,4,5);
        }
        if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6,7,8);
        }
        if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWins(1,4,7);
        }
        if((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2,5,8);
        }
        if((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0,4,8);
        }
        if((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(2,4,6);
        }

        // o win conditions
        if((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0,1,2);
        }
        if((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3,4,5);
        }
        if((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6,7,8);
        }
        if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWins(1,4,7);
        }
        if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2,5,8);
        }
        if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0,4,8);
        }
        if((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(2,4,6);
        }
        int catsCheck = 0;
        for (JButton button : buttons) {
            if (button.getText() != "") {
                catsCheck++;
            }
            if (catsCheck == 9) {
                catsGame();
            }
        }

    }

    private void catsGame() {
        text.setText("Cats Game!");
        text.setForeground(Color.gray);
        playAgain();
    }

    public void xWins(int x, int y, int z) {
        buttons[x].setForeground(Color.green);
        buttons[y].setForeground(Color.green);
        buttons[z].setForeground(Color.green);
        text.setText("X wins!");
        text.setForeground(Color.pink);
        xWinCount++;
        playAgain();
    }

    public void oWins(int x, int y, int z) {
        buttons[x].setForeground(Color.green);
        buttons[y].setForeground(Color.green);
        buttons[z].setForeground(Color.green);
        text.setText("O wins!");
        text.setForeground(Color.cyan);
        yWinCount++;
        playAgain();
    }

    public void playAgain(){
        int result = JOptionPane.showConfirmDialog(null, "Do you want to play again?",
                "X wins: " + xWinCount + " O wins:" + yWinCount, JOptionPane.YES_NO_OPTION);

        if (result == 0) {
            for(int i = 0; i < 9; i++) {
                buttons[i].setText("");
                firstTurn();
            }
        }
        else if (result == 1) {
            System.exit(0);
        }
    }
}
