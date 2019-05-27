package Contact;

import javax.swing.*;

public class Test extends JFrame {

    public Test(){
        this.setVisible(true);
        setSize(300,300);
        add(new ContactForm());
    }
}
