package classes.banques;

import classes.personnes.Client;
import classes.personnes.Conseiller;
import classes.personnes.Directeur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agences {


    public Agences(String identifiantAgence, Directeur directeur) {
        this.identifiantAgence = identifiantAgence;
        this.directeur = null;
    }

    public String getIdentifiantAgence() {
        return identifiantAgence;
    }

    public void setIdentifiantAgence(String identifiantAgence) {
        this.identifiantAgence = identifiantAgence;
    }


    public Directeur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Directeur directeur) {
        this.directeur = directeur;
    }
    public List<Conseiller> getConseillerListAgence() {
        return conseillerListAgence;
    }
    public void setConseillerListAgence(Conseiller conseiller) {
        this.conseillerListAgence.add(conseiller);
    }
    public List<Client> getClientListAgence() {
        return clientListAgence;
    }
    public void setClientListAgence(Client client) {
        this.clientListAgence.add(client);
    }
    protected List<Conseiller> conseillerListAgence = new ArrayList<Conseiller>(Arrays.asList());
    protected List<Client> clientListAgence= new ArrayList<Client>(Arrays.asList());
    protected Directeur directeur;
    protected String identifiantAgence;


}
