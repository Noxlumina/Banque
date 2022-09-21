package classes.personnes;

import interfaces.Operation_Compte;

public class Directeur extends Conseiller implements Operation_Compte {

    public Directeur(String nom, String prenom,Integer age, String identifiantClient, String identifiantConseiller,String identifiantDirecteur) {
        super(nom,prenom,age,identifiantClient,identifiantConseiller);
        this.identifiantDirecteur = identifiantDirecteur;
    }

    public String getIdentifiantDirecteur() {
        return identifiantDirecteur;
    }

    public void setIdentifiantDirecteur(String identifiantDirecteur) {
        this.identifiantDirecteur = identifiantDirecteur;
    }

    protected String identifiantDirecteur;

}
