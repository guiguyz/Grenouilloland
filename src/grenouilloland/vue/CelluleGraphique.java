package grenouilloland.vue;

import tdtp7.exercice1.modele.Etat;
import tdtp7.exercice1.presentateur.Presentateur;
import javax.swing.JButton;
import java.awt.Color;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Representation graphique d'une cellule.
 *
 * @note Chaque instance de cette classe represente son propre listener.
 */
class CelluleGraphique extends JButton implements ActionListener {

    /**
     * Constructeur logique.
     *
     * @param modeleGraphique la valeur de {@link Cellule#modeleGraphique}.
     * @param ligne la valeur de {@link Cellule#ligne}.
     * @param colonne la valeur de {@link Cellule#colonne}.
     */
    public CelluleGraphique(ModeleGraphique modeleGraphique, 
			    int ligne, 
			    int colonne) {

	// Recopie des arguments.
	this.modeleGraphique = modeleGraphique;
	this.ligne = ligne;
	this.colonne = colonne;

	// Mise a jour de la couleur de cette cellule en fonction de l'etat
	// de la cellule correspondante dans le modele.
	mettreAJour();

	// Declaration de cette instance comme son propre listener.
	addActionListener(this);

    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Cellule#modeleGraphique}.
     */
    public ModeleGraphique lireModeleGraphique() {
	return modeleGraphique;
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

    @Override
    public void actionPerformed(ActionEvent evt) {
	modeleGraphique.lireVue().cbBasculer(this);
    }

    /**
     * Met a jour la couleur de cette cellule en fonction de l'etat de la
     * cellule correspondante dans le modele.
     *
     * @note A la seule exception du constructeur logique, toute invocation
     *   de cette methode ne doit etre realisee que si un verrou est pose sur
     *   la vue.
     */
    protected void mettreAJour() {
		
	// Obtention de la vue proprietaire du modele graphique.
	final Vue vue = modeleGraphique.lireVue();

	// Obtention du presentateur associe a la vue.
	final Presentateur presentateur = vue.lirePresentateur();

	// Obtention de l'etat de la cellule associee.
	final Etat etat = presentateur.etat(ligne, colonne);

	// Mise a jour.
	setBackground(couleurs.get(etat));

    }
    
    /**
     * Codes des couleurs associes aux cellules.
     */
    protected static final HashMap< Etat, Color > couleurs;
    static {
	couleurs = new HashMap< Etat, Color >();
	couleurs.put(Etat.Morte, Color.yellow);
	couleurs.put(Etat.Vivante, Color.red);	
    }

    /**
     * Representation graphique du modele proprietaire de cette cellule.
     */
    protected final ModeleGraphique modeleGraphique;

    /**
     * Numero de ligne de la cellule du modele correspondante.
     */
    protected final int ligne;

    /**
     * Numero de colonne de la cellule du modele correspondante.
     */
    protected final int colonne;

}