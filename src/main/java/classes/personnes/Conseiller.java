package classes.personnes;

import classes.banques.Agences;
import classes.banques.Banques;
import classes.comptes.Compte;
import classes.comptes.CompteCourant;
import classes.comptes.CompteEpargne;
import classes.comptes.CompteRemunere;
import interfaces.Operation_Compte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conseiller extends Client implements Operation_Compte {
    public Conseiller(String nom, String prenom, Integer age, String identifiantClient, String identifiantConseiller) {
        super(nom, prenom, age, identifiantClient);
        this.identifiantConseiller = identifiantConseiller;
    }

    //  protected Integer numClient = 0;

    public List getClientList() {
        return ClientList;
    }

    public void setClientList(Client client) {
        ClientList.add(client);
    }

    protected List ClientList = new <Client>ArrayList();


    public String getIdentifiantConseiller() {
        return identifiantConseiller;
    }

    public void setIdentifiantConseiller(String identifiantConseiller) {
        this.identifiantConseiller = identifiantConseiller;
    }

    protected String identifiantConseiller;

    //    protected Agence[] = listeAgence
    public void ouvertureCompte(Client client, Banques banques) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("création d'un compte courant(1),remunere(2),epargne(3)");
        int choixCompte = scanner.nextInt();
        if (choixCompte == 1) {
            Compte compte = new CompteCourant((client.nom + client.age + "courant"), 0.0, client, 0.0);
            client.setListeCompte(compte);
            banques.setComptelist(compte);
        } else if (choixCompte == 2) {
            Compte compte = new CompteRemunere((client.nom + client.age + "remunere"), 0.0, client);
            client.setListeCompte(compte);
            banques.setComptelist(compte);
        } else if (choixCompte == 3) {
            Compte compte = new CompteEpargne((client.nom + client.age + "epargne"), 0.0, client);
            client.setListeCompte(compte);
            banques.setComptelist(compte);
        } else System.out.println("choix non valide");
    }

    public void fermetureCompte(Client client, Banques banques) {
        Scanner scanner = new Scanner(System.in);
        String identifiantCompteFerme = scanner.next();
        for (int j = 0; j <= client.listeCompte.size(); j++) {
            if (client.listeCompte.get(j).getIdentifiantCompte().equals(identifiantCompteFerme)) {
                client.getListeCompte().remove(j);
            }
        }
        for (int i = 0; i <= banques.getComptelist().size(); i++) {
            if (banques.getComptelist().get(i).getIdentifiantCompte().equals(identifiantCompteFerme)) {
                banques.getComptelist().remove(i);
            }
        }
    }


    public void ajoutClient(Banques banque, Conseiller conseiller, String identifiantAgences, Client client) {
        for (Agences item : banque.getAgenceList()
        ) {
            if (item.getIdentifiantAgence().equals(identifiantAgences)) {
          /*      Scanner scanner = new Scanner(System.in);
                System.out.println("Entrer le nom du client");
                String nom = scanner.next();
                System.out.println("Entrer le prenom du client");
                String prenom = scanner.next();
                System.out.println("Entrer l'age du client");
                Integer age = scanner.nextInt();
                Client client = new Client(nom, prenom, age, (nom + age));*/
                this.setClientList(client);
                banque.setClientList(client);
                setClientList(client);
            }
        }
    }

    public void modificationClient(Banques banques) {
        Scanner scanner = new Scanner(System.in);
        String identifiantClient = scanner.next();
        for (int j = 0; j <= banques.getClientList().size(); j++) {
            if (banques.getClientList().get(j).getIdentifiantClient().equals(identifiantClient)) {
                System.out.println("Entrer le nom du client");
                String nom = scanner.next();
                banques.getClientList().get(j).setNom(nom);
                System.out.println("Entrer le prenom du client");
                String prenom = scanner.next();
                banques.getClientList().get(j).setPrenom(prenom);
                System.out.println("Entrer l'age du client");
                Integer age = scanner.nextInt();
                banques.getClientList().get(j).setAge(age);
                Client client = new Client(nom, prenom, age, (nom + age));
            }
        }
    }

    public void suppressionClient(Banques banques) {
        Scanner scanner = new Scanner(System.in);
        String identifiantClient = scanner.next();
        for (int j = 0; j <= banques.getClientList().size(); j++) {
            if (banques.getClientList().get(j).getIdentifiantClient().equals(identifiantClient)) {
                banques.getClientList().remove(j);
            }
        }

    }
}



