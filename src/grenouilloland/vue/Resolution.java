package grenouilloland.vue;

import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

/**
 * Classe representant une barre de defilement permettant de controler la
 * resolution du jeu.
 *
 * @note chaque instance de cette classe est son propre listener.
 */
class Resolution extends JScrollBar implements AdjustmentListener {

    /**
     * Constructeur logique.
     *
     * @param orientation l'orientation de la barre.
     * @param vue la valeur de {@link Resolution#vue}.
     */
    public Resolution(int orientation, Vue vue) {

	// Invocation du constructeur de la classe de base.
	super(orientation,
	      vue.lirePresentateur().resolution(),
	      1,
	      vue.lirePresentateur().lireResolutionMin(),
	      vue.lirePresentateur().lireResolutionMax() + 1);

	// Recopie des arguments specifiques a cette classe.
	this.vue = vue;

	// L'instance est declaree comme son propre listener.
	addAdjustmentListener(this);

    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Resolution#vue}.
     */
    public Vue lireVue() {
	return vue;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent evt) {
	vue.cbNouveauModele(getValue());
    }
    
    /**
     * Vue proprietaire de cette barre.
     */
    protected Vue vue;
    
}