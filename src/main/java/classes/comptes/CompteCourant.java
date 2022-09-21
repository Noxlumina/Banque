package classes.comptes;

import classes.personnes.Client;

public class CompteCourant extends Compte {
    public CompteCourant(String identifiantCompte,Double solde, Client client) {
        super(identifiantCompte,solde,client);
    }
}
