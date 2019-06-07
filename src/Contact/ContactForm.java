package Contact;

import javax.swing.*;
import java.awt.*;

public class ContactForm extends JLabel {

    private JTextField prenom= new JTextField();
    JTextField nom = new JTextField();
    private JTextField number = new JTextField();
    private JTextField location = new JTextField();
    private JTextField birthday = new JTextField();
    private Label prenomL= new Label("Prenom :");
    private Label nomL= new Label("Nom :");
    private Label numberL= new Label("Numero :");
    private Label birthdayL= new Label("anniversaire :");
    private Label locationL= new Label("adresse :");



    ContactForm(){
        GridLayout gridLayout=new GridLayout(5,3);
        setLayout(gridLayout);
        add(nomL);
        add(nom);
        add(prenomL);
        add(prenom);
        add(numberL);
        add(number);
        add(locationL);
        add(location);
        add(birthdayL);
        add(birthday);
        revalidate();
        repaint();
    }
    ContactForm(Contact contact){
        GridLayout gridLayout=new GridLayout(5,3);
        setLayout(gridLayout);
        nom.setText(contact.getNom());
        prenom.setText(contact.getPrenom());
        number.setText(contact.getTelephone());
        location.setText(contact.getLocation());
        birthday.setText(contact.getBirthday());
        add(nomL);
        add(nom);
        add(prenomL);
        add(prenom);
        add(numberL);
        add(number);
        add(locationL);
        add(location);
        add(birthdayL);
        add(birthday);
    }
    public void setcontact(Contact contact){
        contact.setNom(nom.getText());
        contact.setPrenom(prenom.getText());
        contact.setTelephone(number.getText());
        contact.setLocation(location.getText());
        contact.setBirthday(birthday.getText());
    }



}
