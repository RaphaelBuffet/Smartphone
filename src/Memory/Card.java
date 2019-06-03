package Memory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Card extends JButton {

    private boolean cardMatched;
    private boolean cardSelected;

    private String back;


    public Card(String back)
    {
        this.back = back;
        cardSelected = false;
        cardMatched = false;
    }

    public String getBack() {
        return back;
    }

    public void setMatched(boolean matched) {
        cardMatched = matched;
    }

    public void setSelected(boolean selected) {
        cardSelected = selected;
    }

    public boolean isCMatched() {
        if (cardMatched == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCSelected() {
        if (cardSelected == true) {
            return true;
        } else {
            return false;
        }
    }
}
