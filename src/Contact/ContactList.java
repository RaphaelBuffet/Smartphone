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
    private ContactForm saveform;
    private int temp;



    ContactList(ContactHeader contactHeader,ContactApp contactApp){
        deSerializeObject();
        Button[] buttons=new Button[contacts.size()];
        setBackground(Color.BLACK);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400,buttons.length*55));


        for (int i = 0; i < buttons.length; i++) {
            buttons[i]=new Button(contacts.get(i).toString());
            add(buttons[i]);
            temp=i;
            buttons[i].setPreferredSize(new Dimension(460,50));
            /*buttons[i].addActionListener(e -> {
                contactHeader.changeButton(contactApp);
                ContactForm contactForm= new ContactForm(contacts.get(temp));
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                contactHeader.enableDelete();
                contactHeader.enableBack();
            });*/
        }
        for (int i=0;i<contacts.size();i++){
            System.out.println(contacts.get(i));
        }
        if(contacts.size()>0)
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactForm contactForm= new ContactForm(contacts.get(0));
                contactHeader.setContactForm(contactForm);
                contactHeader.changeButton();
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                contactHeader.enableDelete();
                contactHeader.enableBack();
                contactHeader.setCurrentuser(0);
            }
        });
        if(contacts.size()>1)
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactForm contactForm= new ContactForm(contacts.get(1));
                contactHeader.setContactForm(contactForm);
                contactHeader.changeButton();
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                contactHeader.enableDelete();
                contactHeader.enableBack();
                contactHeader.setCurrentuser(1);
            }
        });
        if(contacts.size()>2)
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactHeader.changeButton();
                ContactForm contactForm= new ContactForm(contacts.get(2));
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                contactHeader.enableDelete();
                contactHeader.enableBack();
                contactHeader.setCurrentuser(2);
            }
        });
        if(contacts.size()>3)
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactHeader.changeButton();
                ContactForm contactForm= new ContactForm(contacts.get(3));
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                contactHeader.enableDelete();
                contactHeader.enableBack();
                contactHeader.setCurrentuser(3);
            }
        });
        if(contacts.size()>4)
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactForm contactForm= new ContactForm(contacts.get(4));
                contactHeader.setContactForm(contactForm);
                contactHeader.changeButton();
                contactApp.setContactForm(contactForm);
                contactApp.changecard("ContactForm");
                contactHeader.enableDelete();
                contactHeader.enableBack();
                contactHeader.setCurrentuser(4);
            }
        });
        if(contacts.size()>6)
            buttons[6].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContactForm contactForm= new ContactForm(contacts.get(6));
                    contactHeader.setContactForm(contactForm);
                    contactHeader.changeButton();
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                    contactHeader.enableBack();
                    contactHeader.setCurrentuser(6);
                }
            });
        if(contacts.size()>7)
            buttons[7].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContactForm contactForm= new ContactForm(contacts.get(7));
                    contactHeader.setContactForm(contactForm);
                    contactHeader.changeButton();
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                    contactHeader.enableBack();
                    contactHeader.setCurrentuser(7);
                }
            });
        if(contacts.size()>8)
            buttons[8].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContactForm contactForm= new ContactForm(contacts.get(8));
                    contactHeader.setContactForm(contactForm);
                    contactHeader.changeButton();
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                    contactHeader.enableBack();
                    contactHeader.setCurrentuser(8);
                }
            });
        if(contacts.size()>9)
            buttons[9].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContactForm contactForm= new ContactForm(contacts.get(9));
                    contactHeader.setContactForm(contactForm);
                    contactHeader.changeButton();
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                    contactHeader.enableBack();
                    contactHeader.setCurrentuser(9);
                }
            });
        if(contacts.size()>10)
            buttons[10].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContactForm contactForm= new ContactForm(contacts.get(10));
                    contactHeader.setContactForm(contactForm);
                    contactHeader.changeButton();
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                    contactHeader.enableBack();
                    contactHeader.setCurrentuser(10);
                }
            });
        if(contacts.size()>5)
            buttons[5].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ContactForm contactForm= new ContactForm(contacts.get(5));
                    contactHeader.setContactForm(contactForm);
                    contactHeader.changeButton();
                    contactApp.setContactForm(contactForm);
                    contactApp.changecard("ContactForm");
                    contactHeader.enableDelete();
                    contactHeader.enableBack();
                    contactHeader.setCurrentuser(5);
                }
            });

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
            for (int i=0;i<contacts.size();i++){
                System.out.println(contacts.get(i));
            }
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

    public void setSaveform(ContactForm saveform) {
        this.saveform = saveform;
    }

    public void addContact(){contacts.add(new Contact(contacts.size(),saveform.getnom(),saveform.getprenom(),saveform.getnumber(),saveform.getlocation(),saveform.getbirthday()));
        updateUI();}
    public void changeContact(int place){contacts.remove(place);
                                contacts.add(new Contact(place,saveform.getnom(),saveform.getprenom(),saveform.getnumber(),saveform.getlocation(),saveform.getbirthday()));
                                updateUI();
    }





}
