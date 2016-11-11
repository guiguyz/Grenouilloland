package grenouilloland.modele;

import java.util.Iterator;

/**
 * Classe representant un iterateur de cases voisines.
 */
class Iterateur implements Iterator {

    /**
     * Constructeur logique.
     *
     * @param centre la valeur de {@link Iterateur#centre}.
     * @param proprietaire la valeur de {@link Iterateur#proprietaire}.
     */
    public Iterateur(Cellule centre, Cellule[][] proprietaire) {
	this.centre = centre;
	this.proprietaire = proprietaire;
	rang = 0;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Iterateur#centre}.
     */
    public Cellule lireCentre() {
	return centre;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Iterateur#proprietaire}.
     */
    public Cellule[][] lireProprietaire() {
	return proprietaire;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Iterateur#rang}.
     */
    public int lireRang() {
	return rang;
    }

    @Override
    public boolean hasNext() {
	return rang < deltas.length;
    }

    @Override
    public Cellule next() {

	// Numero de la derniere ligne ou de la derniere colonne.
	final int derniere = proprietaire.length - 1;

	// Calcul du numero de ligne de la voisine courante.
	int ligne = centre.lireLigne() + deltas[rang][0];
	if (ligne < 0) {
	    ligne = derniere;
	}
	else if (ligne > derniere) {
	    ligne = 0;
	}

	// Calcul du numero de colonne de la voisine courante.
	int colonne = centre.lireColonne() + deltas[rang][1];
	if (colonne < 0) {
	    colonne = derniere;
	}
	else if (colonne > derniere) {
	    colonne = 0;
	}

	// Obtention de la voisine courante.
	final Cellule voisine = proprietaire[ligne][colonne];

	// Avancer dans l'enumeration pour la prochaine fois.
	rang ++;

	// Retourner la voisine courante.
	return voisine;

    }

    @Override
    public void remove() {
    }

    /** 
     * Couples de deltas permettant de passer sur les cases voisines. Ces
     * couples sont enumeres dans le sens des aiguilles d'une montre :
     *    7  0  1
     *    6  c  2
     *    5  4  3
     */
    protected static final int[][] deltas = {
	{ 0, -1 }, // Voisine 0
	{ 1, -1 }, // Voisine 1
	{ 1,  0 }, // Voisine 2
	{ 1,  1 }, // Voisine 3
	{ 0,  1 }, // Voisine 4
	{-1,  1 }, // Voisine 5
	{-1,  0 }, // Voisine 6
	{-1, -1 }  // Voisine 7
    }; 

    /**
     * Cellule reperee par cet iterateur.
     */
    protected final Cellule centre;

    /**
     * Proprietaire des cellules.
     */
    protected final Cellule[][] proprietaire;

    /**
     * Rang de la voisine courante dans l'enumeration.
     */
    protected int rang;

}