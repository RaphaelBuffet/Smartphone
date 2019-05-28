package Contact;

import javax.swing.*;
import java.awt.*;

public class ContactForm extends JFrame {

    private JTextField prenom;
    private JTextField nom;
    private JTextField number;


    ContactForm(){
        add(prenom);
        add(nom);
        add(number);
    }

}
