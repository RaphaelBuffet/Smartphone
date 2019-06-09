package Contact;

import java.io.Serializable;

public class Contact implements Serializable {

    private String nom;
    private String prenom;
    private String telephone;
    private String location;
    private String birthday;
    private String score;

    // constructeurs
    public Contact(String nom,String prenom,String telephone,String location,String birthday,String score){
        this.nom=nom;
        this.prenom=prenom;
        this.telephone=telephone;
        this.location=location;
        this.birthday=birthday;
        this.score=score;
    }

    // getter et setter
    public String getLocation() {
        return location;
    }

    public String getBirthday() {
        return birthday;
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
        return (score);
    }

    public void setScore(String score) {
        this.score = score;
    }
}
