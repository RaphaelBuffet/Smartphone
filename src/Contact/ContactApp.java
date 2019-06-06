package Contact;


import Ressources.Button;
import frame.FrameBases;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;



public class ContactApp extends JPanel {

    ContactHeader contactHeader=new ContactHeader();
    ContactList contactList=new ContactList(contactHeader);

    JScrollPane scrollPane=new JScrollPane(contactList);
    public ContactApp(FrameBases mainFrame){
        add(contactHeader,BorderLayout.NORTH);
        setBackground(Color.BLACK);

        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(470,680));
        add(scrollPane);

    }
    public void serializeObject(){
        contactList.serializeObject();
    }

}
