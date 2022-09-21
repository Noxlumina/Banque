package classes.personnes;

import classes.comptes.Compte;
import classes.comptes.CompteCourant;
import interfaces.Operation_Compte;

public class Conseiller extends Client implements Operation_Compte {
    public Conseiller(String nom, String prenom,Integer age, String identifiantClient, String identifiantConseiller) {
        super(nom,prenom,age,identifiantClient);
        this.identifiantConseiller = identifiantConseiller;
    }

    public String getIdentifiantConseiller() {
        return identifiantConseiller;
    }

    public void setIdentifiantConseiller(String identifiantConseiller) {
        this.identifiantConseiller = identifiantConseiller;
    }

    protected String identifiantConseiller;
//    protected Agence[] = listeAgence

  //  public Compte ouvertureCompte(Client client){

 //       Compte compte1 = new CompteCourant();
   //     return compte1;

   // }

    public void fermetureCompte(Compte compte){
    }



    public void ajoutClient(){
    }

    public void modificationClient(Client client){
    }

    public void suppressionClient(Client client){
    }






}
