package classes.comptes;

import classes.personnes.Client;

import java.time.LocalDate;

public class CompteRemunere extends Compte {
    public CompteRemunere(String identifiantCompte, Double solde, Client client) {
        super(identifiantCompte, solde, client);
        this.tauxInteret = 0.5;
    }

    protected Double seuilCompte = 7000.0;

    protected Double interet = 0.04;

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    protected Double tauxInteret;

    public void verserInteret(Double interet) {
        this.setSolde(this.getSolde() + interet);
        if (this.getSolde() > seuilCompte) this.setSolde(seuilCompte);
    }

    public Double calculerInteret(Double solde) {
        if (LocalDate.now().getDayOfMonth() == 05) {
            this.interet = this.getSolde() * this.getTauxInteret();
            System.out.println(this.interet);
            return this.interet;
        } else {
            this.interet = 0.0;
            System.out.println(this.interet);
            return this.interet;
        }
    }

    public void interetCheck() {
        calculerInteret(this.getSolde());
        verserInteret(this.interet);
    }
}
