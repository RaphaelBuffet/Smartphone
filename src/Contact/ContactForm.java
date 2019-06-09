package Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JLabel {

    private JTextField prenom= new JTextField();
    private JTextField nom = new JTextField();
    private JTextField number = new JTextField();
    private JTextField location = new JTextField();
    private JTextField birthday = new JTextField();
    private String score;
    private JButton scoreButton = new JButton(score);
    private JTextField prenomL= new JTextField("Prenom :");
    private JTextField nomL= new JTextField("Nom :");
    private JTextField numberL= new JTextField("Numero :");
    private JTextField birthdayL= new JTextField("anniversaire :");
    private JTextField locationL= new JTextField("adresse :");
    private JTextField scoreL= new JTextField("score :");
    private boolean exist;
    private ContactApp contactApp;
    private int tempscore;



    ContactForm(ContactApp contactApp){
        this.contactApp=contactApp;
        GridLayout gridLayout=new GridLayout(6,3);
        setLayout(gridLayout);
        nomL.setEditable(false);
        prenomL.setEditable(false);
        numberL.setEditable(false);
        locationL.setEditable(false);
        birthdayL.setEditable(false);
        scoreL.setEditable(false);
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
        add(scoreL);
        add(scoreButton);
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempscore=contactApp.getScore();
                scoreButton.setText(Integer.toString(tempscore));
            }
        });
        exist=false;
    }
    ContactForm(Contact contact,ContactApp contactapp){
        this.contactApp=contactapp;
        GridLayout gridLayout=new GridLayout(6,3);
        setLayout(gridLayout);
        nomL.setEditable(false);
        prenomL.setEditable(false);
        numberL.setEditable(false);
        locationL.setEditable(false);
        birthdayL.setEditable(false);
        scoreL.setEditable(false);
        nom.setText(contact.getNom());
        prenom.setText(contact.getPrenom());
        number.setText(contact.getTelephone());
        location.setText(contact.getLocation());
        birthday.setText(contact.getBirthday());
        score=contact.getScore();
        scoreButton.setText(score);
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
        add(scoreL);
        add(scoreButton);
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempscore=contactApp.getScore();
                contact.setScore(Integer.toString(tempscore));
                scoreButton.setText(Integer.toString(tempscore));
            }
        });
        exist=true;
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
    public String getscore(){
        return scoreButton.getText();
    }
}
