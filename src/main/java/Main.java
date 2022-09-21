import classes.banques.Agences;
import classes.banques.Banques;
import classes.comptes.Compte;
import classes.comptes.CompteCourant;
import classes.comptes.CompteEpargne;
import classes.comptes.CompteRemunere;
import classes.personnes.Client;
import classes.personnes.Conseiller;
import classes.personnes.Directeur;

public class Main {
    public static void main(String[] args) {

        //création d'une banque
        Banques BibiBanque = new Banques("BibiBanque");
        //        ouverture agence
        BibiBanque.ouvrirAgence("BibiBanqueNord");
        //création d'un directeur
        Directeur directeur = new Directeur("Martez", "Carolina", 40, "002", "002", "001");
        //création d'un conseiller
        Conseiller conseiller = new Conseiller("Sue", "Cindy", 29, "002", "001");
        BibiBanque.assignDirecteur("BibiBanqueNord", directeur, BibiBanque);
        BibiBanque.assignConseiller(BibiBanque, conseiller, "BibiBanqueNord");
        //création d'un client
        Client client = new Client("Darpentier", "Paul", 35, "001");
        //création des compte
        CompteCourant compteCourant = new CompteCourant("courant1", 1500.0, client, 0.0);
        CompteEpargne compteEpargne = new CompteEpargne("epargne1", 500.0, client);
        CompteRemunere compteRemunere = new CompteRemunere("remunere", 1000.0, client);
        //méthode pour afficher, retirer et verser de l'argent d'un compte
        client.affichageSolde(compteCourant);
        client.retraitArgent(150.0, compteCourant);
        //impossible de retirer de l'argent autre qu'un compte courant, message d'erreur
        client.retraitArgent(150.0, compteEpargne);
        client.affichageSolde(compteCourant);
        client.versementArgent(300.0, compteCourant);


        conseiller.ajoutClient(BibiBanque,conseiller,"BibiBanqueNord",client);
        conseiller.ouvertureCompte(client,BibiBanque);
        BibiBanque.afficherClientBanque("001");
        conseiller.fermetureCompte(client,BibiBanque);
        compteRemunere.interetCheck();


    }
}
