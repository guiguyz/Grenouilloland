package grenouilloland.modele;

/**
 * Classe representant le jeu de la vie.
 */
public class Modele {

    /**
     * Constructeur logique.
     *
     * @param resolution la resolution de ce jeu.
     * @param defaut l'etat par defaut des cellules.
     */
    public Modele(int resolution, Etat defaut) {
	grille = new Cellule[resolution][resolution];
	for (int i = 0; i < resolution; i ++) {
	    for (int j = 0; j < resolution; j ++) {
		grille[i][j] = new Cellule(i, j, defaut);
	    }
	}
    }

    /**
     * Retourne la resolution de ce jeu.
     *
     * @return la resolution de ce jeu.
     */
    public int resolution() {
	return grille.length;
    }

    /**
     * Retourne l'etat de la cellule dont les numeros de ligne et de colonne
     * sont fournis en arguments.
     *
     * @param ligne le numero de ligne.
     * @param colonne le numero de colonne.
     * @return l'etat de la cellule dont les numeros de ligne et de colonne
     *   sont fournis en arguments.
     */
    public Etat etat(int ligne, int colonne) {
	return grille[ligne][colonne].lireEtat();
    }

    /**
     * Fait basculer la cellule dont les numeros de ligne et de colonne
     * sont fournis en arguments, d'un etat a un autre.
     *
     * @param ligne le numero de ligne.
     * @param colonne le numero de colonne.
     */
    public void basculer(int ligne, int colonne) {
	grille[ligne][colonne].basculer();
    }

    /**
     * Reinitialise toutes les cellules a l'etat fourni en argument.
     *
     * @param etat l'etat.
     */
    public void reinitialiser(Etat etat) {
	for (int i = 0; i < grille.length; i ++) {
	    for (int j = 0; j < grille.length; j ++) {
		grille[i][j].ecrireEtat(etat);
	    }
	}
    }

    /**
     * Calcule la generation suivante.
     */
    public void suivante() {

	// Archivage de l'etat des cellules avant mise a jour.
	for (int i = 0; i < grille.length; i ++) {
	    for (int j = 0; j < grille.length; j ++) {
		grille[i][j].archiver();
	    }
	}

	// Mise a jour des cellules.
	for (int i = 0; i < grille.length; i ++) {
	    for (int j = 0; j < grille.length; j ++) {
		grille[i][j].mettreAJour(grille);
	    }
	}

    }

    /**
     * Grille de cellules.
     */
    protected Cellule[][] grille;

}