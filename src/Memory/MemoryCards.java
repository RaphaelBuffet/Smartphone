package Memory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Random;

public class MemoryCards extends JPanel implements ActionListener {

    private Card[][] cards;
    private String[] colors = {"Blue", "Blue", "Red", "Red", "Green", "Green", "Magenta", "Magenta", "Orange", "Orange", "Cyan", "Cyan", "Black", "Black", "Pink", "Pink"};

    private Field field;
    private Color color;
    private int score;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Card c3;

    private MemoryApp memoryApp;

    public MemoryCards(MemoryApp memoryApp){
        this.memoryApp = memoryApp;
        setBackground(Color.BLACK);
        score =100;
        GridLayout layout = new GridLayout(4, 4, 5, 5);
        setLayout(layout);

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        memoryApp.getMemoryHeader().getLabelScor().setText("SCORE: " + score);
        cards = new Card[4][4];
        mix();
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

    public void mix() {
        for (int i = 0; i < colors.length; i++) {
            int pos = (int)(Math.random()*colors.length);
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
                        }
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

            if (isEndOfGame() == true) {
                JOptionPane.showMessageDialog(this, "You won with the score of " + score + " and you have use " + (100-score)+" moves !");
                memoryApp.resetGame();
                score = 101;
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
        score--;
        memoryApp.getMemoryHeader().getLabelScor().setText("SCORE: " + score);
    }
}
