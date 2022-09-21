package classes.comptes;

import classes.personnes.Client;

public class CompteRemunere extends Compte {
    public CompteRemunere(String identifiantCompte,Double solde, Client client) {
        super(identifiantCompte,solde,client);
    }
}
