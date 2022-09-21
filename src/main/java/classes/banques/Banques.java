package classes.banques;

import classes.comptes.Compte;
import classes.personnes.Client;
import classes.personnes.Conseiller;
import classes.personnes.Directeur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banques {
    public Banques(String nomBanque) {
        this.nomBanque = nomBanque;
    }
    /*
     *fonction permettant d'ouvrir une agence
     */
    public void ouvrirAgence(String identifiantAgence) {
        Agences agences = new Agences(identifiantAgence,null);
        setAgenceList(agences);
    }
    /*
     *fonction permettant d'assigner un directeur à une agence
     */
    public void assignDirecteur(String identifiantAgences, Directeur directeur, Banques banque) {
        for (Agences item : banque.agenceList
        ) {
            if (item.identifiantAgence.equals(identifiantAgences)) {
                setDirecteurList(directeur);
                item.setDirecteur(directeur);
                item.setConseillerListAgence((Conseiller) directeur);
                banque.setConseillerList((Conseiller) directeur);
                banque.setClientList((Client) directeur);
            }
        }
    }
    /*
     *fonction permettant d'assigner un conseiller à une agence
     */
    public void assignConseiller(Banques banque, Conseiller conseiller, String identifiantAgences) {
        for (Agences item : banque.agenceList
        ) {
            if (item.identifiantAgence.equals(identifiantAgences)) {
                setConseillerList(conseiller);
                item.setConseillerListAgence(conseiller);
                banque.setClientList(conseiller);
            }
        }
    }

    public void afficherClientBanque(String identifiantClient ){
        for (Client item:clientList
             ) {if (item.getIdentifiantClient().equals(identifiantClient))
        {System.out.println("je suis un client");}
        }
    }


    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(Client client) {
        this.clientList.add(client);
    }

    public List<Conseiller> getConseillerList() {
        return conseillerList;
    }

    public void setConseillerList(Conseiller conseiller) {
        this.conseillerList.add(conseiller);
    }

    public List<Directeur> getDirecteruList() {
        return directeurList;
    }

    public void setDirecteurList(Directeur directeur) {
        this.directeurList.add(directeur);
    }

    public List<Agences> getAgenceList() {
        return agenceList;
    }

    public void setAgenceList(Agences agence) {
        this.agenceList.add(agence);
    }
    public List<Compte> getComptelist() {
        return comptelist;
    }

    public void setComptelist(Compte compte) {
        this.comptelist.add(compte);
    }

    protected List<Client> clientList = new ArrayList<Client>();
    protected List<Conseiller> conseillerList = new ArrayList<Conseiller>();
    protected List<Directeur> directeurList = new ArrayList<Directeur>();
    protected List<Agences> agenceList = new ArrayList<Agences>();

    protected List<Compte> comptelist = new ArrayList<Compte>();
    protected String nomBanque;


}
