package Contact;

import javax.swing.*;
import java.awt.*;

public class ContactForm extends JLabel {

    private JTextField prenom= new JTextField();
    JTextField nom = new JTextField();
    private JTextField number = new JTextField();
    private JTextField location = new JTextField();
    private JTextField birthday = new JTextField();
    private JTextField prenomL= new JTextField("Prenom :");
    private JTextField nomL= new JTextField("Nom :");
    private JTextField numberL= new JTextField("Numero :");
    private JTextField birthdayL= new JTextField("anniversaire :");
    private JTextField locationL= new JTextField("adresse :");
    private boolean exist;



    ContactForm(){
        GridLayout gridLayout=new GridLayout(5,3);
        setLayout(gridLayout);
        nomL.setEditable(false);
        prenomL.setEditable(false);
        numberL.setEditable(false);
        locationL.setEditable(false);
        birthdayL.setEditable(false);
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
        exist=false;
    }
    ContactForm(Contact contact){
        GridLayout gridLayout=new GridLayout(5,3);
        setLayout(gridLayout);
        nomL.setEditable(false);
        prenomL.setEditable(false);
        numberL.setEditable(false);
        locationL.setEditable(false);
        birthdayL.setEditable(false);
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
        exist=true;
    }
    public void setcontact(Contact contact){
        contact.setNom(nom.getText());
        contact.setPrenom(prenom.getText());
        contact.setTelephone(number.getText());
        contact.setLocation(location.getText());
        contact.setBirthday(birthday.getText());
    }
    public boolean validation()
    {
        boolean validated;
        Validate validate = new Validate();
        validated = validate.isNotEmpty(prenom);
        if(!validated)
            return validated;
        validated = validate.isNotEmpty(number);
        if(!validated)
            return validated;
        validated = validate.phoneValide(number);
        if(!validated)
            return validated;
        return validated;
    }
    public boolean exist(){
        return exist;
    }
    public String getnom(){
        return nom.getText();
    }
    public String getprenom(){
        return prenom.getText();
    }
    public String getnumber(){
        return number.getText();
    }
    public String getbirthday(){
        return birthday.getText();
    }
    public String getlocation(){
        return location.getText();
    }




}
