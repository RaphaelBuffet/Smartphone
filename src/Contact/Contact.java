package Contact;

import java.io.Serializable;

public class Contact implements Serializable {

    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String location;
    private String birthday;
    private int score;
    private String scoreString;

    public Contact(int id,String nom,String prenom,String telephone,String location,String birthday){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.telephone=telephone;
        this.location=location;
        this.birthday=birthday;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String toString() { return nom+" "+prenom; }

    public String getTelephone() {
        return telephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getScore() {
        scoreString=Integer.toString(score);
        return (scoreString);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
