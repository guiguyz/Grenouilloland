package grenouilloland.modele;

/**
 * Classe representant une position dans un repere cartesien
 */
public class Position {

    /**
     * Constructeur logique.
     *
     * @param ligne la valeur de {@link Position#ligne}.
     * @param colonne la valeur de {@link Position#colonne}.
     */
    public Position(int ligne, int colonne) {
	this.ligne = ligne;
	this.colonne = colonne;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Position#ligne}.
     */
    public int lireLigne() {
	return ligne;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Position#colonne}.
     */
    public int lireColonne() {
	return colonne;
    }

    /**
     * Retourne la voisine de cette position selon la direction fournie en
     * argument.
     *
     * @param direction la direction.
     * @return la voisine de cette position selon la direction fournie en
     *   argument.
     */
    public boolean voisine(Position position) {
        int x = this.ligne-position.ligne;
        int y = this.colonne-position.colonne;
	    return Math.abs(x)+Math.abs(y)==1;
    }

    public boolean estEgale(Position position){
        return position.ligne==this.ligne && position.colonne==this.colonne;
    }

    /**
     * Numero de ligne.
     */
    protected final int ligne;

    /**
     * Numero de colonne.
     */
    protected final int colonne;

}