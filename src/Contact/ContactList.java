package Contact;

import Ressources.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ContactList extends JPanel {

    private ArrayList<Contact> contacts= new ArrayList<Contact>();
    private Contact tempcontact;
    private int place=0;



    ContactList(ContactHeader contactHeader,ContactApp contactApp){
        deSerializeObject();
        Button[] buttons=new Button[contacts.size()];
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400,buttons.length*55));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i]=new Button(contacts.get(i).toString());
            add(buttons[i]);
            buttons[i].setPreferredSize(new Dimension(460,50));
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Test(contacts.get(1));
                    contactHeader.changeButton(contactApp);
                    ContactForm contactForm= new ContactForm(contacts.get(1));
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                }
            });
        }
        for (int i=0;i<contacts.size();i++){
            System.out.println(contacts.get(i));
        }

    }

    public void serializeObject()
    {
        try
        {
            FileOutputStream fichier = new FileOutputStream("serials/contacts.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fichier);
            oos.writeObject(contacts);
            oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void deSerializeObject()
    {
        try
        {
            FileInputStream fichier = new FileInputStream("serials/contacts.ser");
            ObjectInputStream ois = new ObjectInputStream(fichier);
            contacts = (ArrayList<Contact>) ois.readObject();
            ois.close();
        }
        catch (IOException e)
        {
            contacts = new ArrayList<Contact>();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();

        }
    }
    public void removecontact(int place){
        contacts.remove(contacts.get(place));
    }





}
