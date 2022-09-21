package classes.personnes;

public abstract class Personne {
    public Personne(String nom, String prenom,Integer age) {
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    protected String nom;
    protected String prenom;
    protected Integer age;

}
