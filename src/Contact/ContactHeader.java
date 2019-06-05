package Contact;

import Ressources.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactHeader extends JPanel {

    private Button addContact=new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/add.png")),(new Color(0,191,255)),Color.CYAN);
    private Button saveContact=new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/save.png")),(new Color(0,191,255)),Color.CYAN);
    public ContactHeader(){
        setBackground((new Color(0,191,255)));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(480,60));
        add(addContact,BorderLayout.EAST);
        add(new JLabel("Contact"));
        addContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeButton();
                new Test();
            }
        });

    }
    public void changeButton(){
        remove(addContact);
        add(saveContact,BorderLayout.EAST);
        revalidate();
        saveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(saveContact);
                add(addContact,BorderLayout.EAST);
                revalidate();
            }
        });
    }

}
