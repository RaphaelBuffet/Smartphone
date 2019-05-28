package Contact;

public class Contact {

    String nom;
    String prenom;
    int telephone;

    public Contact(String nom,String prenom,int telephone){
        this.nom=nom;
        this.prenom=prenom;
        this.telephone=telephone;
    }

    @Override
    public String toString() {
        return nom+" "+prenom;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
