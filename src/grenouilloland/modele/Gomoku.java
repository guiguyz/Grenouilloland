package grenouilloland.modele;

/**
 * Classe representant le jeu du Gomoku.
 */
public class Gomoku {

    /**
     * Constructeur logique.
     *
     * @param resolution la resolution du plateau de jeu.
     */
    public Gomoku(int resolution) {
	grille = new Pion[resolution][resolution];
	for (int i = 0; i < resolution; i ++) {
	    for (int j = 0; j < resolution; j ++) {
		grille[i][j] = Pion.NiCroixNiCercle;
	    }
	}
    }

    /**
     * Retourne la resolution de ce plateau.
     *
     * @return la resolution de ce plateau.
     */
    public int resolution() {
	return grille.length;
    }

    /**
     * Retourne le contenu de la case dont la position est fournie en argument.
     *
     * @param position la position.
     * @return le contenu de la case correspondante.
     */
    public Pion lireCase(Position position) {
	return grille[position.lireLigne()][position.lireColonne()];
    }

    /**
     * Joue un nouveau coup et retourne le resultat produit.
     *
     * @param pion le pion du joueur ayant le trait.
     * @param position la position designant la case sur lequel le joueur desire
     *   poser son pion.
     * @return le resultat produit par ce nouveau coup.
     */
    public Resultat jouer(Pion pion, Position position) {

	// Nombre de pions a aligner pour remporter la partie.
	final int alignement = 5;

	// Coup invalide.
	if (! peutPoser(position)) {
	    return Resultat.Invalide;
	}

	// La case etant valide, nous y deposons le pion.
	poser(pion, position);

	// Boucle de parcours des direction de l'intervalle [Nord,Nord-Est].
	for (Direction dir = Direction.Nord; 
	     dir != Direction.Sud; 
	     dir = dir.suivante()) {

	    // Compteur de pions associe a cette direction.
	    int compteur = 1;

	    // Nous comptons le nombre de pions identiques en remontant dans le
	    // sens de la direction courante.
	    {
		Position pos = position.voisine(dir);
		while (estValide(pos) && lireCase(pos) == pion) {
		    compteur ++;
		    if (compteur == alignement) {
			return Resultat.Gagnant;
		    }
		    pos = pos.voisine(dir);
		}
	    }

	    // Nous comptons a present le nombre de pions identiques en
	    // descendant dans le sens de la direction opposee.
	    final Direction oppDir = dir.opposee();
	    {
		Position pos = position.voisine(oppDir);
		while (estValide(pos) && lireCase(pos) == pion) {
		    compteur ++;
		    if (compteur == alignement) {
			return Resultat.Gagnant;
		    }
		    pos = pos.voisine(oppDir);
		}		
	    }

	}

	// Si nous sommes toujours ici, c'est que le coup joue n'ait ni
	// invalide, ni gagant.
	return Resultat.NiInvalideNiGagnant;
	
    }

    /**
     * Indique si la position fournie en argument designe une case du plateau
     * de jeu.
     *
     * @param position la position.
     * @return true si la position designe une case du plateau de jeu sinon
     *   false.
     */
    protected boolean estValide(Position position) {
	final int ligne = position.lireLigne();
	if (ligne < 0 || ligne >= grille.length) {
	    return false;
	}
	final int colonne = position.lireColonne();
	if (colonne < 0 || colonne >= grille.length) {
	    return false;
	}
	return true;
    }

    /**
     * Indique si un pion peut etre pose sur la case dont la position en fournie
     * en argument.
     *
     * @param position la position.
     * @return true si un pion peut etre pose sur la case correspondante sinon
     *   false.
     */
    protected boolean peutPoser(Position position) {
	if (! estValide(position)) {
	    return false;
	}
	return grille[position.lireLigne()][position.lireColonne()] == 
	    Pion.NiCroixNiCercle;
    }

    /**
     * Depose un pion sur la case dont la position est fournie en argument.
     *
     * @param pion le pion.
     * @param position la position.
     */
    protected void poser(Pion pion, Position position) {
	grille[position.lireLigne()][position.lireColonne()] = pion;
    }

    /**
     * Grille de pions.
     */
    protected Pion[][] grille;

}