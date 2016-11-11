package grenouilloland.modele;

/**
 * Classe representant une cellule.
 */
class Cellule {

    /**
     * Constructeur logique.
     
     * @param ligne la valeur de {@link Cellule#ligne}.
     * @param colonne la valeur de {@link Cellule#colonne}.
     * @param etat la valeur de {@link Cellule#etat}.
     */
    public Cellule(int ligne, int colonne, Etat etat) {
	this.ligne = ligne;
	this.colonne = colonne;
	this.etat = etat;
	archive = etat;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Cellule#ligne}.
     */
    public int lireLigne() {
	return ligne;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Cellule#colonne}.
     */
    public int lireColonne() {
	return colonne;
    }
    
    /**
     * Accesseur.
     *
     * @return la valeur de {@link Cellule#etat}.
     */
    public Etat lireEtat() {
	return etat;
    }

    /**
     * Accesseur.
     *
     * @param etat la nouvelle valeur de {@link Cellule#etat}.
     */
    public void ecrireEtat(Etat valeur) {
	etat = valeur;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Cellule#archive}.
     */
    public Etat lireArchive() {
	return archive;
    }

    /**
     * Accesseur.
     *
     * @param valeur la nouvelle valeur de {@link Cellule#archive}.
     */
    public void ecrireArchive(Etat valeur) {
	archive = valeur;
    }
    
    /**
     * Indique si cette cellule est vivante.
     *
     * @return true si cette cellule est vivante sinon false.
     */
    public boolean estVivante() {
	return etat == Etat.Vivante;
    }

    /**
     * Fait basculer cette cellule d'un etat a un autre.
     */
    public void basculer() {
	etat = etat == Etat.Morte ? Etat.Vivante : Etat.Morte;
    }

    /**
     * Archive l'etat actuel de cette cellule.
     */
    public void archiver() {
	archive = etat;
    }

    /**
     * Met a jour l'etat de cette cellule en fonction de son etat anterieur et
     * celui de ses voisines.
     *
     * @param proprietaire le proprietaire de cette cellule.
     */
    public void mettreAJour(Cellule[][] proprietaire) {

	// Branchement d'un itérateur de cellules voisines.
	Iterateur iterateur = new Iterateur(this, proprietaire);

	// Decompte des voisines vivantes.
	int decompte = 0;
	while (iterateur.hasNext()) {
	    decompte += iterateur.next().lireArchive().ordinal();
	}

	// Mise a jour.
	if (estVivante()) {
	    etat = decompte == 2 || decompte == 3 ? Etat.Vivante : Etat.Morte; 
	}
	else {
	    etat = decompte == 3 ? Etat.Vivante : Etat.Morte;
	}

    }

    /**
     * Numero de ligne de cette cellule.
     */
    protected final int ligne;

    /**
     * Numero de colonne de cette cellule.
     */
    protected final int colonne;

    /**
     * Etat de cette cellule.
     */
    protected Etat etat;

    /**
     * Etat de cette cellule a l'iteration precedente.
     */
    protected Etat archive;

}