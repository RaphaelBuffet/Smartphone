package Contact;

public class Contact {

    private String nom;
    private String prenom;
    private String telephone;
    private String location;
    private String birthday;

    public Contact(String nom,String prenom,String telephone,String location,String birthday){
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
    public String toString() {
        return nom+" "+prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
