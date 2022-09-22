package classes.personnes;

import classes.comptes.Compte;
import classes.comptes.CompteCourant;
import interfaces.Operation_Compte;

import java.util.ArrayList;
import java.util.List;

public class Client extends Personne implements Operation_Compte {
    public Client(String nom, String prenom, Integer age, String identifiantClient) {
        super(nom, prenom, age);
        this.identifiantClient = identifiantClient;
    }

    public String getIdentifiantClient() {
        return identifiantClient;
    }

    public void setIdentifiantClient(String identifiantClient) {
        this.identifiantClient = identifiantClient;
    }

    protected String identifiantClient;

    public List getListeCompte() {
        return listeCompte;
    }

    public void setListeCompte(Compte compte) {
        this.listeCompte.add(compte);
    }

    protected List<Compte> listeCompte = new ArrayList<Compte>();

    @Override
    public void affichageSolde(Compte compte) {
        System.out.println(compte.getSolde());
    }

    @Override
    public double retraitArgent(Double somme, Compte compte) {
        if (compte instanceof CompteCourant) {
            if (compte.getSolde() > 0) {
                //   compte.setSolde(compte.getSolde()-somme);
                ((CompteCourant) compte).retirerArgent(somme);

            } else System.out.println("solde insufisant");
            return compte.getSolde();
        } else System.out.println(
                "on ne peut retirer de l'argent que d'un compte courant"
        );
        return compte.getSolde();
    }


    @Override
    public double versementArgent(Double somme, Compte compte) {
        compte.setSolde(compte.getSolde() + somme);
        return compte.getSolde();
    }

    @Override
    public void virementArgent(Double somme, Compte compte_origine, Compte compte_destination) {
        compte_origine.getSolde();
        compte_origine.setSolde(compte_origine.getSolde() - somme);
        compte_destination.setSolde(compte_destination.getSolde() + somme);
        compte_destination.getSolde();
    }
}
