package interfaces;

import classes.comptes.Compte;

public interface Operation_Compte {

    public void affichageSolde(Compte compte);
    public double retraitArgent(Double somme, Compte compte);
    public double versementArgent(Double somme,Compte compte);
    public void virementArgent(/*Double somme, Compte compte_origine,Compte compte_destination*/);



}
