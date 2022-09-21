package classes.comptes;

import classes.personnes.Client;

public class CompteCourant extends Compte {
    public CompteCourant(String identifiantCompte,Double solde, Client client, Double seuilNegatif) {
        super(identifiantCompte,solde,client);
        this.seuilNegatif=0.0;
    }

    public Double retirerArgent(Double somme){
        if (this.getSolde()>this.getSeuilNegatif()){
        this.setSolde(this.getSolde()-somme);
        return  this.getSolde();}
        else System.out.println("seuil insuffisant sur le compte, pensez à le réapprivisonner");
        return  this.getSolde();
    }

    public Double getSeuilNegatif() {
        return seuilNegatif;
    }

    public void setSeuilNegatif(Double seuilNegatif) {
        this.seuilNegatif = seuilNegatif;
    }

    protected Double seuilNegatif;
}
