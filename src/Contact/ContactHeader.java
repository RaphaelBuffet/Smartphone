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
                contactApp.deleteContact(1);
                contactApp.updateList();
                contactApp.changecard("ListeContact");
            }
        });
        addContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeButton(contactApp);
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
            }
        });

    }
    public void changeButton(ContactApp contactApp) {
        remove(addContact);
        add(saveContact, BorderLayout.EAST);
        revalidate();
        saveContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contactForm.validation()) {
                    remove(saveContact);
                    add(addContact, BorderLayout.EAST);
                    contactApp.changecard("ListeContact");
                    disableDelete();
                    disableBack();
                    revalidate();
                    contactApp.addContact();
                }
                if (!contactForm.exist()) {
                    contactApp.addContact();
                }

            }
        });
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

}
