package Contact;


import Ressources.Button;
import frame.FrameBases;

import javax.swing.*;
import java.awt.*;

public class ContactApp extends JPanel {

    JScrollPane scrollPane=new JScrollPane(new ContactList());
    public ContactApp(FrameBases mainFrame){
        add(new ContactHeader(),BorderLayout.NORTH);

        setBackground(Color.CYAN);

        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(470,680));
        add(scrollPane);




    }
}
