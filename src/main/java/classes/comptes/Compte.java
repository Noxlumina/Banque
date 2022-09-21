package classes.comptes;

import classes.personnes.Client;

public abstract class Compte {
    public Compte(String identifiantCompte, Double solde, Client client) {
        this.identifiantCompte = identifiantCompte;
        this.solde = solde;
    }

    public String getIdentifiantCompte() {
        return identifiantCompte;
    }

    public void setIdentifiantCompte(String identifiantCompte) {
        this.identifiantCompte = identifiantCompte;
    }

    protected String identifiantCompte;

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    protected  Double solde;
}
