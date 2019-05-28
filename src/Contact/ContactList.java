package Contact;

import Ressources.Button;

import javax.swing.*;
import java.awt.*;

public class ContactList extends JPanel {

    Contact[] contacts=new Contact[]
    {
                new Contact("Buffet", "Raphael", 2),
                new Contact("Buffet", "Loan", 2),
                new Contact("Buffet", "Raymond", 2),
                new Contact("Buffet", "Muriel", 2),
                new Contact("Buffet", "Mélissa", 2),
                new Contact("Buffet", "Mathieu", 2),
                new Contact("Buffet", "Mélissa", 2),
                new Contact("Buffet", "Jhon", 2),
                new Contact("Buffet", "Léa", 2),
                new Contact("Buffet", "Damien", 2),
                new Contact("Buffet", "Kévin", 2),
                new Contact("Buffet", "Danielo", 2),
                new Contact("Buffet", "Gaufrette", 2),
                new Contact("Buffet", "Guillaume", 2),
                new Contact("Buffet", "Sarah", 2),

    };

    Button[] buttons=new Button[contacts.length];

    ContactList(){
        setBackground(new Color(120,120,20));
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400,buttons.length*55));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i]=new Button(contacts[i].toString());
            add(buttons[i]);
            buttons[i].setPreferredSize(new Dimension(460,50));
        }
    }


}
