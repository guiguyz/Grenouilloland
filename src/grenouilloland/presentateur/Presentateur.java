package grenouilloland.presentateur;

import grenouilloland.modele.Modele;
import grenouilloland.modele.Etat;
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
     *
     * @note le modele est instancie a partir de cellules mortes.
     */
    public Presentateur(int resolutionMin, int resolutionMax, int resolution) {
	this.resolutionMin = resolutionMin;
	this.resolutionMax = resolutionMax;
	modele = new Modele(resolution, Etat.Morte);
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
	return modele.resolution();
    }

    /**
     * Retourne l'etat de la cellule du modele dont les numeros de ligne et
     * de colonne sont fournis en arguments.
     *
     * @param ligne le numero de ligne.
     * @param colonne le numero de colonne.
     * @return l'etat de la cellule correspondante.
     */
    public Etat etat(int ligne, int colonne) {
	return modele.etat(ligne, colonne);
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
     * Instancie un nouveau modele.
     * 
     * @param resolution la resolution du nouveau modele.
     */
    public void nouveauModele(int resolution) {
	modele = new Modele(resolution, Etat.Morte);
    }

    /**
     * Reinitialise le modele a partir de cellules mortes.
     */
    public void reinitialiser() {
	modele.reinitialiser(Etat.Morte);
    }

    /**
     * Fait changer d'etat la cellule dont les numeros de ligne et de colonne
     * sont fournis en arguments.
     *
     * @param ligne le numero de ligne.
     * @param colonne le numero de colonne.
     */
    public void basculer(int ligne, int colonne) {
	modele.basculer(ligne, colonne);
    }

    /**
     * Fait passer le modele a la generation suivante.
     */
    public void suivante() {
	modele.suivante();
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