package Contact;


import Ressources.Button;
import frame.FrameBases;

import javax.swing.*;
import java.awt.*;

public class ContactApp extends JPanel {

    JScrollPane scrollPane=new JScrollPane(new ContactList());
    public ContactApp(FrameBases mainFrame){
        add(new ContactHeader(),BorderLayout.NORTH);
        Contact c1=new Contact("Buffet","Raphael",789354775);
        Contact c2=new Contact("Buffet","Muriel",787674500);
        Button b1=new Button();
        Button b2=new Button();

        b1.setName("coucou");
        b1.setText("dada");
        Button[] buttons=new Button[] {b1,b2};
        b2.setText(c2.toString());
        //add(new ContactHeader());

        setBackground(Color.CYAN);

        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(470,680));
        add(scrollPane);




    }
}
