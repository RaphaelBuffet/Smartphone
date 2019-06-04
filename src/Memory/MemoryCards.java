package Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Random;

public class MemoryCards extends JPanel implements ActionListener {
    private static final int NUMBER_OF_ROWS = 4;
    private static final int NUMBER_OF_COLUMNS = 4;
    private static final int HORIZONTAL_GAP = 5;
    private static final int VERTICAL_GAP = 5;
    private static final int PANEL_BORDER = 20;


    private Card[][] cards = null;
    private String[] colors = {"Blue", "Blue", "Red", "Red", "Green", "Green", "Magenta", "Magenta", "Orange", "Orange", "Cyan", "Cyan", "Black", "Black", "Pink", "Pink"};

    private Random random;
    private Field field;
    private Color color;
    private int score = 0;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Card c3;
    private int cptIsMatched = 0;

    private MemoryApp memoryApp;

    public MemoryCards(MemoryApp memoryApp){
        this.memoryApp = memoryApp;
        setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP);
        setLayout(layout);

        setBorder(BorderFactory.createEmptyBorder(PANEL_BORDER,PANEL_BORDER,PANEL_BORDER,PANEL_BORDER));
        memoryApp.getMemoryHeader().getLabelScor().setText("SCORE: " + score);
        cards = new Card[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        shuffle();
        setCards();

    }
    public void setCards() {
        int a = 0;
        for (int row = 0; row < cards.length; row++) {
            for (int column = 0; column < cards[0].length; column++) {
                cards[row][column] = new Card(colors[a]);
                add(cards[row][column]);
                cards[row][column].addActionListener(this);
                a++;
            }
        }
    }

    public void shuffle() {
        random = new Random();
        for (int i = 0; i < colors.length; i++) {
            int pos = random.nextInt(colors.length);
            String temp = colors[i];
            colors[i] = colors[pos];
            colors[pos] = temp;
        }
    }

    public void setColors(Card card) {
        try {
            field = Class.forName("java.awt.Color").getField(card.getBack().toUpperCase());
            color = (Color) field.get(null);
            card.setBackground(color);
        } catch (Exception ex) {
            color = null;
        }
    }

    public void showCardColor() {
        for (int row = 0; row < cards.length; row++) {
            for (int column = 0; column < cards[0].length; column++) {
                if (selectedCard == cards[row][column]) {
                    if (!cards[row][column].isCMatched()) {
                        if (!cards[row][column].isCSelected()) {
                            setColors(cards[row][column]);
                            cards[row][column].setSelected(true);
                            mouseClick++;
                            System.out.println(mouseClick);
                        } else {
                            System.out.println("This field is already selected");
                        }
                    } else {
                        System.out.println("This file is already matched.");
                    }
                }
            }
        }
    }


    int mouseClick = 0;

    public void hideColor() {
        if (mouseClick > 1 && mouseClick % 2 != 0) {
            c1.setBackground(new JButton().getBackground());
            c2.setBackground(new JButton().getBackground());
            c1 = null;
            c2 = null;
        }
    }

    public void check() {
        if (c1.getBack().equals(c2.getBack())) {
            c1.setMatched(true);
            c2.setMatched(true);

            cptIsMatched++;
            System.out.println("score: " + cptIsMatched);

            if (isEndOfGame() == true) {
                JOptionPane.showMessageDialog(this, "You won in " + score + " moves !");
                memoryApp.resetGame();
                score = -1;
            }
            c1 = null;
            c2 = null;
            c3 = null;

            c1 = selectedCard;
            showCardColor();

        } else {
            showCardColor();
            c1.setSelected(false);
            c2.setSelected(false);
            hideColor();
            c1 = c3;
            c3 = null;
        }
    }

    public boolean isEndOfGame() {

        for (Card[] cards2d : cards) {
            for (Card cards1d : cards2d) {
                if (cards1d.isCMatched() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public void doTurn() {
        if (c1 == null && c2 == null) {
            if (!selectedCard.isCMatched()) {
                c1 = selectedCard;
                showCardColor();
            }
        }
        if (c1 != null && c1 != selectedCard && c2 == null) {
            if (!selectedCard.isCMatched()) {
                c2 = selectedCard;
                showCardColor();
            }
        }

        if (c1 != null && c2 != null && c2 != selectedCard && c3 == null) {
            c3 = selectedCard;
            check();
        }
    }

    Object source;
    @Override
    public void actionPerformed(ActionEvent e) {
        source = e.getSource();

        selectedCard = (Card) source;

        doTurn();
        score++;
        memoryApp.getMemoryHeader().getLabelScor().setText("SCORE: " + score);
    }

    public int getScore() {
        return score;
    }
}
