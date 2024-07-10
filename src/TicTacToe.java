import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel AnnouncingTheWinner = new JLabel();
    private static JButton button1 = new JButton();
    private static JButton button2 = new JButton();
    private static JButton button3 = new JButton();
    private static JButton button4 = new JButton();
    private static JButton button5 = new JButton();
    private static JButton button6 = new JButton();
    private static JButton button7 = new JButton();
    private static JButton button8 = new JButton();
    private static JButton button9 = new JButton();

    private static JPanel boardPanel = new JPanel();
    private static JLabel xLabel = new JLabel();
    private static JLabel oLabel = new JLabel();

    private static JLabel textLabel = new JLabel();
    private static int oScore = 0;
    private static int xScore = 0;
    JButton[] buttons = {button1, button2, button3, button4, button5, button6, button7, button8, button9};

    private static JButton playAgainButton = new JButton();
    private JLabel currentSymbol = new JLabel();
    private static JPanel matchPanel = new JPanel();
    private int currentTurn = 1;

    private ImageIcon crossSymbol = new ImageIcon("crossSymbol.png");

    private ImageIcon circleSymbol = new ImageIcon("circleSymbol.png");
    private static ArrayList<JButton> clickedButtons = new ArrayList<>();
    private JPanel TurnPanel = new JPanel();

    public TicTacToe() {


        //-----------------instances---------------------


        JPanel TopPanel = new JPanel();


        JLabel BannerLabel = new JLabel();
        JLayeredPane layeredPane = new JLayeredPane();

        ImageIcon Banner = new ImageIcon("Banner.jpg");
        ImageIcon appIcon = new ImageIcon("AppIcon.jpg");


        //-----------------kitchen-----------------------
        frame.setTitle("TicTacToe");
        frame.setVisible(true);
        frame.setIconImage(appIcon.getImage());
        frame.setBounds(450, 150, 690, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0xFFC000));

        //-------------Panels----------------------------

        TopPanel.setVisible(true);
        TopPanel.setBackground(Color.RED);
        TopPanel.setBounds(0, 0, 800, 75);
        TopPanel.setPreferredSize(new Dimension(100, 100));


        matchPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        matchPanel.setBounds(0, 145, 200, 200);
        matchPanel.setVisible(true);


        matchPanel.setLayout(new GridLayout(3, 3, 5, 5));
        matchPanel.setBackground(new Color(0x320015));


        TurnPanel.isOpaque();


        TurnPanel.add(currentSymbol);

        TurnPanel.setForeground(Color.blue);
        TurnPanel.setBackground(Color.BLUE);
        TurnPanel.setSize(50, 50);
        TurnPanel.setBounds(233, 213, 60, 60);
        TurnPanel.setLayout(new GridLayout());


        boardPanel.setVisible(true);
        boardPanel.setLayout(new GridLayout());
        boardPanel.setBackground(new Color(0xFFB75D));
        boardPanel.setBounds(440, 170, 250, 130);
        boardPanel.add(xLabel);
        boardPanel.add(oLabel);
        boardPanel.setBorder(BorderFactory.createLineBorder(new Color(0x14F2F3), 5));
        boardPanel.add(playAgainButton);


//---------------------buttons------------

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);

        button1.setName("1");
        button2.setName("2");
        button3.setName("3");
        button4.setName("4");
        button5.setName("5");
        button6.setName("6");
        button7.setName("7");
        button8.setName("8");
        button9.setName("9");


        playAgainButton.setVisible(true);
        playAgainButton.setText("Play Again!");
        playAgainButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        playAgainButton.setBounds(30, 350, 140, 45);
        playAgainButton.setBackground(Color.RED);
        playAgainButton.setBorder(BorderFactory.createLineBorder(Color.blue, 6));
        playAgainButton.setEnabled(true);
        playAgainButton.setFocusable(false);
        playAgainButton.addActionListener(this);
        playAgainButton.setLayout(null);
        playAgainButton.setVerticalAlignment(JLabel.BOTTOM);
        playAgainButton.setHorizontalAlignment(JLabel.CENTER);

        //--------------------labels-----------
        currentSymbol.setIcon(crossSymbol);
        currentSymbol.setVisible(true);
        currentSymbol.setVerticalAlignment(JLabel.CENTER);
        currentSymbol.setHorizontalAlignment(JLabel.CENTER);


        BannerLabel.setBounds(0, 0, 800, 140);
        BannerLabel.setVisible(true);
        BannerLabel.setOpaque(true);
        BannerLabel.setIcon(Banner);


        AnnouncingTheWinner.setText("Congratulations!");
        AnnouncingTheWinner.setFont(new Font("Arial", 3, 20));
        AnnouncingTheWinner.setVerticalTextPosition(JLabel.TOP);
        AnnouncingTheWinner.setHorizontalTextPosition(JLabel.CENTER);
        AnnouncingTheWinner.setBounds(235, 170, 180, 150);
        AnnouncingTheWinner.setBackground(new Color(0xFFCA2F));
        AnnouncingTheWinner.setOpaque(true);
        AnnouncingTheWinner.setVisible(false);
        AnnouncingTheWinner.setIcon(crossSymbol);
        AnnouncingTheWinner.setBorder(BorderFactory.createLineBorder(new Color(0xFF751F), 10));
        AnnouncingTheWinner.setLayout(new GridLayout());

        xLabel.setIcon(crossSymbol);
        xLabel.setVerticalTextPosition(JLabel.CENTER);
        xLabel.setHorizontalTextPosition(JLabel.RIGHT);
        xLabel.setVerticalAlignment(JLabel.CENTER);
        xLabel.setHorizontalAlignment(JLabel.LEFT);
        xLabel.setText(" - 0 ");
        xLabel.setFont(new Font("Calibra", 1, 25));

        oLabel.setIcon(circleSymbol);
        oLabel.setVerticalTextPosition(JLabel.CENTER);
        oLabel.setHorizontalTextPosition(JLabel.LEFT);
        oLabel.setVerticalAlignment(JLabel.CENTER);
        oLabel.setHorizontalAlignment(JLabel.RIGHT);
        oLabel.setText(" 0 - ");
        oLabel.setFont(new Font("Calibra", 1, 25));



        //=================Adding To the instances================
        matchPanel.add(button1);
        matchPanel.add(button2);
        matchPanel.add(button3);
        matchPanel.add(button4);
        matchPanel.add(button5);
        matchPanel.add(button6);
        matchPanel.add(button7);
        matchPanel.add(button8);
        matchPanel.add(button9);

        layeredPane.setBounds(0, 0, 690, 500);

        layeredPane.add(boardPanel, 5);
        layeredPane.add(playAgainButton, 4);
        layeredPane.add(BannerLabel, 3);
        layeredPane.add(TurnPanel, 2);
        layeredPane.add(AnnouncingTheWinner, 1);
        layeredPane.add(matchPanel, 0);

        frame.add(layeredPane);


    }


    public static void main(String[] args) {
        new TicTacToe();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //------------reset button function--------------

        if (e.getSource() == playAgainButton) {
            currentTurn = 1;

            for (int i = 0; i < 9; i++) {
                buttons[i].setIcon(null);

                if (clickedButtons.contains(buttons[i])) {
                    clickedButtons.remove(buttons[i]);
                }

            }

            AnnouncingTheWinner.setIcon(null);

            AnnouncingTheWinner.setVisible(false);

            TurnPanel.setVisible(true);
            TurnPanel.setOpaque(true);
            currentSymbol.setVisible(true);
            currentSymbol.setIcon(crossSymbol);
            TurnPanel.add(currentSymbol);
            result = "NDY";

            Random random = new Random();


            frame.getContentPane().setBackground(new Color(random.nextInt(0, 255), random.nextInt(0, 255), random.nextInt(0, 255)));
            playAgainButton.setBackground(new Color(random.nextInt(0, 255), random.nextInt(0, 255),random.nextInt(0, 255)));

        }

        //---------------buttons1-9 actions---------------


        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {

                if (!clickedButtons.contains(buttons[i]) && returnWinner().equals("NDY")) {
                    if (currentTurn % 2 == 0) {
                        buttons[i].setIcon(circleSymbol);
                        currentTurn++;
                        currentSymbol.setIcon(crossSymbol);

                    } else {
                        buttons[i].setIcon(crossSymbol);
                        currentTurn++;
                        currentSymbol.setIcon(circleSymbol);

                    }
                    clickedButtons.add(buttons[i]);
                } else {
                    continue;
                }

                //Executing the winner

                if (returnWinner().equals("cross")) {
                    TurnPanel.setVisible(false);

                    AnnouncingTheWinner.setVisible(true);
                    AnnouncingTheWinner.setIcon(crossSymbol);
                    AnnouncingTheWinner.setText("Congratulations!");
                    AnnouncingTheWinner.setFont(new Font("Arial", 3, 20));
                    AnnouncingTheWinner.setVerticalTextPosition(JLabel.TOP);
                    AnnouncingTheWinner.setHorizontalTextPosition(JLabel.CENTER);

                    xLabel.setText("- " + ++xScore + " ");

                } else if (returnWinner().equals("circle")) {
                    TurnPanel.setVisible(false);

                    AnnouncingTheWinner.setVisible(true);
                    AnnouncingTheWinner.setIcon(circleSymbol);
                    AnnouncingTheWinner.setText("Congratulations!");
                    AnnouncingTheWinner.setFont(new Font("Arial", 3, 20));
                    AnnouncingTheWinner.setVerticalTextPosition(JLabel.TOP);
                    AnnouncingTheWinner.setHorizontalTextPosition(JLabel.CENTER);

                    oLabel.setText(" " + ++oScore + " -");

                } else if (clickedButtons.size() == 9 && returnWinner().equals("NDY")) {
                    TurnPanel.setVisible(false);
                    AnnouncingTheWinner.setVisible(true);
                    AnnouncingTheWinner.setIcon(null);
                    AnnouncingTheWinner.setText("DRAW!");
                    AnnouncingTheWinner.setHorizontalTextPosition(JLabel.CENTER);
                    AnnouncingTheWinner.setVerticalTextPosition(JLabel.CENTER);
                    AnnouncingTheWinner.setFont(new Font("Arial", Font.BOLD, 45));
                }

                if (clickedButtons.size() == 9) {
                    System.out.println("Full capacity!");
                    currentSymbol.setVisible(false);
                }


            }
        }
    }

    private static String result = "NDY";

    private static String returnWinner() {


        for (int a = 1; a < 9; a++) {
            String checker = "";

            switch (a) {
                case 1:
                    checker = "" + button1.getIcon() + button2.getIcon() + button3.getIcon();

                    break;
                case 2:
                    checker = "" + button4.getIcon() + button5.getIcon() + button6.getIcon();

                    break;
                case 3:
                    checker = "" + button7.getIcon() + button8.getIcon() + button9.getIcon();

                    break;
                case 4:
                    checker = "" + button1.getIcon() + button4.getIcon() + button7.getIcon();

                    break;
                case 5:
                    checker = "" + button2.getIcon() + button5.getIcon() + button8.getIcon();

                    break;
                case 6:
                    checker = "" + button3.getIcon() + button6.getIcon() + button9.getIcon();

                    break;
                case 7:
                    checker = "" + button1.getIcon() + button5.getIcon() + button9.getIcon();

                    break;
                case 8:
                    checker = "" + button3.getIcon() + button5.getIcon() + button7.getIcon();

                    break;
            }
            //For X winner
            if (checker.equals("crossSymbol.pngcrossSymbol.pngcrossSymbol.png")) {
                result = "cross";
                return result;
            }

            // For O winner
            else if (checker.equals("circleSymbol.pngcircleSymbol.pngcircleSymbol.png")) {
                result = "circle";
                return result;
            }
        }

        return result;
    }

}

