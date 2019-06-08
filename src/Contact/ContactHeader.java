package Contact;

import Ressources.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactHeader extends JPanel {

    private Button addContact=new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/add.png")),(new Color(145,214,206)),new Color(100,200,20));
    private Button saveContact=new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/save.png")),(new Color(145,214,206)),new Color(100,200,20));
    private Button deleteContact=new Button(new ImageIcon(getClass().getClassLoader().getResource("res/Icons/delete.png")),(new Color(145,214,206)),new Color(100,200,20));
    private Button backclick=new Button(new ImageIcon(getClass().getClassLoader().getResource("res/icons/bak.png")),(new Color(145,214,206)),new Color(100,200,20));
    private ContactForm contactForm=new ContactForm();
    public ContactHeader(ContactApp contactApp){
        setBackground((new Color(145,214,206)));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(480,60));
        add(addContact,BorderLayout.EAST);
        add(backclick,BorderLayout.WEST);
        add(deleteContact);
        disableDelete();
        disableBack();
        deleteContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactApp.deleteContact(6);
                contactApp.updateList();
                contactApp.changecard("ListeContact");
            }
        });
        addContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeButton();
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                enableBack();
                revalidate();
            }
        });
        backclick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactForm=new ContactForm();
                contactApp.changecard("ListeContact");
                remove(saveContact);
                add(addContact, BorderLayout.EAST);
                disableDelete();
                disableBack();
            }
        });
        saveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contactForm.validation()) {
                    remove(saveContact);
                    add(addContact, BorderLayout.EAST);
                    contactApp.updateList();
                    contactApp.changecard("ListeContact");
                    disableDelete();
                    disableBack();
                    revalidate();
                    if (!contactForm.exist()) {
                        contactApp.addContact(contactForm);
                        contactForm=new ContactForm();
                    }
                    else {
                        contactApp.changeContact(contactForm);
                    }
                }
            }
        });

    }
    public void changeButton() {
        remove(addContact);
        add(saveContact, BorderLayout.EAST);
        revalidate();

    }
    public void disableDelete(){
        deleteContact.setEnabled(false);
    }
    public void enableDelete(){
        deleteContact.setEnabled(true);
    }
    public void disableBack(){
        backclick.setEnabled(false);
    }
    public void enableBack(){
        backclick.setEnabled(true);
    }

    public void setContactForm(ContactForm contactForm) {
        this.contactForm = contactForm;
    }
}
