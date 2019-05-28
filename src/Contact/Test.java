package Contact;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    public Test(){
        this.setVisible(true);
        setSize(new Dimension(480,740));
        add(new ContactForm());
    }
}
