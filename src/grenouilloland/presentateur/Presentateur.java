package grenouilloland.presentateur;

import grenouilloland.modele.*;
import grenouilloland.vue.Vue;

/**
 * Classe representant le presentateur de l'application.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public class Presentateur {

    /**
     * Constructeur logique.
     *
     * @param resolutionMin la valeur de {@link Presentateur#resolutionMin}.
     * @param resolutionMax la valeur de {@link Presentateur#resolutionMax}.
     * @param resolution    la resolution initiale du modele.
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
     * Resolution du modele.
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

    /**
     * Type d'élément dans la case dont la position est fournie en argument.
     *
     * @param position la position.
     * @return le Type d'élément contenu dans la case correspondante.
     */
    public TypeElement lireType(Position position) {
        return modele.lireType(position);
    }

    /**
     * Accesseur sur le nenuphar en fonction de la position.
     *
     * @return la valeur position de {@link Modele#getNenuphar(Position)}.
     */
    public Nenuphar getNenuphar(Position position) {
        return modele.getNenuphar(position);
    }

    /**
     * Genere le chemin du modele au lancement de partie.
     */
    public void lancerPartie() {
        modele.genereChemin();
    }



    /**
     * Viellit les nenuphars.
     * Genere le chemin du modele durant son évolution.
     */
    public void vieillirNenuphar() {
        modele.vieillirNenuphar();
        modele.genereChemin();
    }

    /**
     * Accesseur sur la grenouille.
     *
     * @return la grenouille {@link Modele#getGrenouille()}.
     */
    public Grenouille getGrenouille() {
        return modele.getGrenouille();
    }

    /**
     * Déplace la grenouille.
     * @param position la nouvelle position de la grenouille
     */
    public void deplacerGrenouille(Position position) {
        modele.deplacerGrenouille(position);
        genererChemin();
    }

    /**
     * Genere le chemin du modele.
     */
    public void genererChemin(){
        modele.genereChemin();
    }

    /**
     * Genere le chemin du modele.
     */
    public boolean gagnant() {
        return modele.gagnant();
    }

    /**
     * Genere le chemin du modele.
     */
    public boolean perdant() { return modele.perdant(); }


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