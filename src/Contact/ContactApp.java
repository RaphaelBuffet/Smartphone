package Contact;


import Ressources.Button;
import frame.FrameBases;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;



public class ContactApp extends JPanel {

    ContactHeader contactHeader=new ContactHeader();

    JScrollPane scrollPane=new JScrollPane(new ContactList(contactHeader));
    public ContactApp(FrameBases mainFrame){
        add(contactHeader,BorderLayout.NORTH);

        setBackground(Color.CYAN);

        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(470,680));
        add(scrollPane);

    }

}
