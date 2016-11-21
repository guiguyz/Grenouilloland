package grenouilloland.presentateur;

import grenouilloland.modele.*;
import grenouilloland.vue.Vue;

/**
 * Classe representant le presentateur de l'application. 
 */
public class Presentateur {

    /**
     * Constructeur logique.
     *
     * @param resolutionMin la valeur de {@link Presentateur#resolutionMin}.
     * @param resolutionMax la valeur de {@link Presentateur#resolutionMax}.
     * @param resolution la resolution initiale du modele.
     */
    public Presentateur(int resolutionMin, int resolutionMax, int resolution) {
	this.resolutionMin = resolutionMin;
	this.resolutionMax = resolutionMax;
	modele = new Modele(resolution);
	vue = new Vue(this);
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Presentateur#resolutionMin}.
     */
    public int lireResolutionMin() {
	return resolutionMin;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Presentateur#resolutionMax}.
     */
    public int lireResolutionMax() {
	return resolutionMax;
    }

    /**
     * Retourne la resolution du modele.
     *
     * @return la resolution du modele.
     */
    public int resolution() {
	return modele.getResolution();
    }

    /**
     * Demarre ce presentateur en affichant la vue.
     */
    public void demarrer() {

	// Calcul des dimensions de tous les composants de la vue.
	vue.pack();

	// Affichage : il existe maintenant deux threads.
	vue.setVisible(true);

    }

    public Nenuphar getNenuphar(Position position){
        return modele.getNenuphar(position);

    }

    public void lancerPartie(){
        modele.genereCheminNenuphar();
    }

    public void etapeSuivante(){
        modele.etapeSuivante();
    }

    public synchronized void viellirNenuphar(){
        modele.viellirNenuphar();
    }

    public Grenouille getGrenouille(){
        return modele.getGrenouille();
    }

    public void deplacerGrenouille(Position position){
        if(!modele.partieFinie()){

            modele.deplacerGrenouille(position);
            modele.genereCheminNenuphar();
            vue.mettreAJour();
        }
        else{
            vue.afficherFin();
        }

    }

    public boolean gagnant(){
        return modele.gagnant();
    }

//    public void creeChemin(){
//        modele.genereCheminNenuphar();
//    }




    /**
     * Instancie un nouveau modele.
     * 
     * @param resolution la resolution du nouveau modele.
     */
    public void nouveauModele(int resolution) {
	modele = new Modele(resolution);
    }


    /**
     * Resolution minimum du modele.
     */
    protected final int resolutionMin;

    /**
     * Resolution maximum du modele.
     */
    protected final int resolutionMax;

    /**
     * Instance du modele.
     */
    protected Modele modele;

    /**
     * Instance de la vue.
     */
    protected final Vue vue;

}