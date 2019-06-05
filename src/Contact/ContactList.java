package Contact;

import Ressources.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactList extends JPanel {

    Contact[] contacts=new Contact[]
    {
                new Contact("Buffet", "Raphael", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Loan", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Raymond", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Muriel", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Mélissa", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Mathieu", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Mélissa", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Jhon", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Léa", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Damien", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Kévin", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Danielo", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Gaufrette", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Guillaume", "2" ,"Sion","23.09.2018"),
                new Contact("Buffet", "Sarah", "2" ,"Sion","23.09.2018"),

    };

    Button[] buttons=new Button[contacts.length];

    ContactList(ContactHeader contactHeader){
        setBackground(new Color(120,120,20));
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400,buttons.length*55));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i]=new Button(contacts[i].toString());
            add(buttons[i]);
            buttons[i].setPreferredSize(new Dimension(460,50));
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Test(contacts[1]);
                    contactHeader.changeButton();

                }
            });
        }
    }


}
