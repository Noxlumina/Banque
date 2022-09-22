import classes.banques.Agences;
import classes.banques.Banques;
import classes.comptes.Compte;
import classes.comptes.CompteCourant;
import classes.comptes.CompteEpargne;
import classes.comptes.CompteRemunere;
import classes.personnes.Client;
import classes.personnes.Conseiller;
import classes.personnes.Directeur;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

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


        /*conseiller.ajoutClient(BibiBanque, conseiller, "BibiBanqueNord", client);
        conseiller.ouvertureCompte(client, BibiBanque);
        BibiBanque.afficherClientBanque("001");
        conseiller.fermetureCompte(client, BibiBanque);
        compteRemunere.interetCheck();*/

        boolean choixValide = false;
        System.out.println("êtes vous un client, un conseiller ou directeur?");
        String choixUtilisateur = scanner.next();
        choixUtilisateur = choixUtilisateur.toUpperCase();
        while (!choixValide) {
            switch (choixUtilisateur) {
                case "CLIENT": {
                    actionClient();
                    choixValide = true;
                    break;
                }
                case "CONSEILLER": {
                    actionConseiller();
                    choixValide = true;
                    break;
                }
                case "DIRECTEUR": {
                    choixValide = true;
                    break;
                }
                default: {
                    System.out.println("choix non valide, recommencer");
                    choixUtilisateur = scanner.next().toUpperCase();
                }
            }
        }
    }

    ;

    public static void actionClient() {
        Client client = new Client("Darpentier", "Paul", 35, "001");
        //création des compte
        CompteCourant compteCourant = new CompteCourant("courant1", 1500.0, client, 0.0);
        CompteEpargne compteEpargne = new CompteEpargne("epargne1", 500.0, client);
        CompteRemunere compteRemunere = new CompteRemunere("remunere", 1000.0, client);
        Scanner scanner = new Scanner(System.in);
        boolean choixValide = false;
        System.out.println("Voulez-vous retirer, verser, effectuer un virement ou afficher");
        String choixClient = scanner.next();
        choixClient = choixClient.toUpperCase();
        while (!choixValide) {
            switch (choixClient) {
                case "RETIRER": {
                    System.out.println("Combien voulez-vous retirer?");
                    Double somme = scanner.nextDouble();
                    client.retraitArgent(somme, compteCourant);
                    choixValide = true;
                    break;
                }
                case "VERSER": {
                    System.out.println("Combien voulez-vous verser?");
                    Double somme = scanner.nextDouble();
                    client.versementArgent(somme, compteCourant);
                    choixValide = true;
                    break;
                }
                case "VIREMENT": {
                    System.out.println("Combien voulez-vous verser?");
                    Double somme = scanner.nextDouble();
                    client.virementArgent(somme, compteCourant, compteEpargne);
                    choixValide = true;
                    break;
                }
                case "AFFICHER": {
                    System.out.println("1 pour compte courant,2 pour compte rémunéré et 3 pour compte épargne");
                    Integer choix = scanner.nextInt();
                    if (choix == 1) {
                        client.affichageSolde(compteCourant);
                    } else if (choix == 2) {
                        client.affichageSolde(compteRemunere);
                    } else if (choix == 3) {
                        client.affichageSolde(compteEpargne);
                    } else System.out.println("choix non valide");
                    choixValide = true;
                    break;
                }
                default: {
                    System.out.println("choix non valide, recommencer");
                    choixClient = scanner.next().toUpperCase();
                }
            }
        }
    }

    public static void actionConseiller() {
        Conseiller conseiller = new Conseiller("Sue", "Cindy", 29, "002", "001");
        Banques BibiBanque = new Banques("BibiBanque");
        Client client = new Client("Darpentier", "Paul", 35, "001");
        BibiBanque.ouvrirAgence("BibiBanqueNord");
        CompteCourant compteCourant = new CompteCourant("courant1", 1500.0, client, 0.0);
        CompteEpargne compteEpargne = new CompteEpargne("epargne1", 500.0, client);
        CompteRemunere compteRemunere = new CompteRemunere("remunere", 1000.0, client);
        //création des compte
        boolean choixValide = false;
        boolean continueConseiller = false;
        System.out.println("Voulez-vous OUVRIR un compte FERMER un compte, AJOUTER un client, le MODIFIER ou le SUPPRIMERr");
        String choixConseiller = scanner.next();
        choixConseiller = choixConseiller.toUpperCase();

        while (!continueConseiller) {

            while (!choixValide) {
                switch (choixConseiller) {
                    case "OUVRIR": {
                        conseiller.ouvertureCompte(client, BibiBanque);
                        choixValide = true;
                        break;
                    }
                    case "FERMER": {
                        conseiller.fermetureCompte(client,BibiBanque);
                        choixValide = true;
                        break;
                    }
                    case "AJOUTER": {
                        conseiller.ajoutClient(BibiBanque,conseiller,"BibiBanqueNord",client);
                        choixValide = true;
                        break;
                    }
                    case "MODIFIER": {
                        conseiller.modificationClient(BibiBanque);
                        choixValide = true;
                        break;
                    }
                    case "SUPPRIMER": {
                        conseiller.suppressionClient(BibiBanque);
                        choixValide = true;
                        break;
                    }
                    default: {
                        System.out.println("choix non valide, recommencer");
                        choixConseiller = scanner.next().toUpperCase();
                    }
                }
            }
            System.out.println("Avez-vous d'autres opérations à faire O pour oui ou N pour non?");
            String continuer = scanner.next().toUpperCase();
            if (continuer.equals("NON")) {
                continueConseiller = true;
            } else {
                choixValide = false;
                System.out.println("Voulez-vous OUVRIR un compte FERMER un compte, AJOUTER un client, le MODIFIER ou le SUPPRIMERr");
                choixConseiller = scanner.next();

            }
        }
    }


}

