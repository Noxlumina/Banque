package classes.comptes;

import classes.personnes.Client;

public class CompteEpargne extends Compte {
    public CompteEpargne(String identifiantCompte, Double solde, Client client) {
        super(identifiantCompte, solde, client);
    }
}
