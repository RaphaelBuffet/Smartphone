package Contact;


import Ressources.Button;
import frame.FrameBases;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;



public class ContactApp extends JPanel {

    private CardLayout cardLayoutContact = new CardLayout();
    private ContactHeader contactHeader=new ContactHeader(this);
    private ContactList contactList=new ContactList(contactHeader,this);
    private JPanel contentPanelContact = new JPanel(cardLayoutContact);
    private ContactForm contactForm= new ContactForm();

    JScrollPane scrollPane=new JScrollPane(contactList);
    public ContactApp(FrameBases mainFrame){
        add(contactHeader,BorderLayout.NORTH);
        setBackground(Color.BLACK);
        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(470,680));
        add(contentPanelContact);
        contentPanelContact.add(scrollPane, "ListeContact");
        cardLayoutContact.show(contentPanelContact, "ListeContact");

    }
    public void serializeObject(){
        contactList.serializeObject();
    }
    public void deserializeObject(){
        contactList.deSerializeObject();
    }
    public void setContactForm(ContactForm contactForm) {
        this.contactForm = contactForm;
        contentPanelContact.add(contactForm,"ContactForm");
    }
    public void changecard(String cardname){
        cardLayoutContact.show(contentPanelContact,cardname);
    }

    public void deleteContact(int place){
        contactList.removecontact(place);
    }
    public void updateList(){
        contentPanelContact.remove(scrollPane);
        ContactList contactLists=new ContactList(contactHeader,this);
        scrollPane=new JScrollPane(contactLists);
        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(470,680));
        contentPanelContact.add(scrollPane,"ListeContact");
        contentPanelContact.updateUI();
    }
    public void addContact(ContactForm saveform){
        contactList.setSaveform(saveform);
        contactList.addContact();
        updateUI();
    }
    public void changeContact(ContactForm saveform){
        contactList.setSaveform(saveform);
        contactList.changeContact();
        updateUI();
    }



}
