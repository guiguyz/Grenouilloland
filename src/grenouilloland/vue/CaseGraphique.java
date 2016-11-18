package grenouilloland.vue;

import grenouilloland.modele.Position;
import grenouilloland.presentateur.Presentateur;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Representation graphique d'une case du plateau de jeu.
 *
 * @note Chaque instance de cette classe represente son propre listener.
 */
class CaseGraphique extends JButton implements ActionListener {


    /**
     * Constructeur logique.
     *
     * @param modeleGraphique la valeur de 
     *   {@link CaseGraphique#modeleGraphique}.
     * @param position la valeur de {@link CaseGraphique#position}.
     */
    public CaseGraphique(ModeleGraphique modeleGraphique, Position position) {

	// Recopie des arguments.
	this.modeleGraphique = modeleGraphique;
	this.position = position;

	// Declaration de cette instance comme son propre listener.
	addActionListener(this);

    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link CaseGraphique#modeleGraphique}.
     */
    public ModeleGraphique lireModeleGraphique() {
	return modeleGraphique;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link CaseGraphique#position}.
     */
    public Position lirePosition() {
	return position;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
	modeleGraphique.lireVue().cbPoser(this);
    }

    /**
     * Met a jour l'icone de cette case graphique en fonction du pion pose dans
     * la case correspondante du modele.
     *
     * @note A la seule exception du constructeur logique, toute invocation
     *   de cette methode ne doit etre realisee que si un verrou est pose sur
     *   la vue.
     */
    protected void mettreAJour() {
		
        // Obtention de la vue proprietaire du modele graphique.
        final Vue vue = modeleGraphique.lireVue();
        vue.lirePresentateur().getNenuphar(position);



    }

    /**
     * Representation graphique du modele proprietaire de cette case.
     */
    protected final ModeleGraphique modeleGraphique;

    /**
     * Position de la cellule du modele correspondante.
     */
    protected final Position position;

}