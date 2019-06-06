package Contact;

import javax.swing.*;
import java.awt.*;

public class ContactForm extends JLabel {

    private JTextField prenom= new JTextField();
    private JTextField nom = new JTextField();
    private JTextField number = new JTextField();
    private JTextField location = new JTextField();
    private JTextField birthday = new JTextField();
    private final Label prenomL= new Label("Prenom :");
    private final Label nomL= new Label("Nom :");
    private final Label numberL= new Label("Numero :");
    private final Label birthdayL= new Label("anniversaire :");
    private final Label locationL= new Label("adresse :");



    ContactForm(){
        GridLayout gridLayout=new GridLayout(5,3);
        setLayout(gridLayout);
        nomL.setText("nom");
        prenomL.setText("prenom");
        numberL.setText("numero");
        locationL.setText("adresse");
        birthdayL.setText("anniversaire");
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
    ContactForm(Contact contact){
        GridLayout gridLayout=new GridLayout(5,3);
        setLayout(gridLayout);
        nomL.setText("nom");
        prenomL.setText("prenom");
        numberL.setText("numero");
        locationL.setText("adresse");
        birthdayL.setText("anniversaire");
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

}
