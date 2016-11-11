package grenouilloland.vue;

import grenouilloland.presentateur.Presentateur;
import javax.swing.JPanel;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 * Representation graphique du modele.
 */
class ModeleGraphique extends JPanel {

    /**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ModeleGraphique#vue}.
     */
    public ModeleGraphique(Vue vue) {

	// Recopie des arguments.
	this.vue = vue;

	// Obtention du presentateur associe a la vue.
	final Presentateur presentateur = vue.lirePresentateur();

	// Obtention de la resolution du modele.
	final int resolution = presentateur.resolution();

	// Creation de la grille de cellules. 
	cellules = new CelluleGraphique[resolution][resolution];
	for (int i = 0; i < resolution; i ++) {
	    for (int j = 0; j < resolution; j ++) {
		cellules[i][j] = new CelluleGraphique(this, i, j);
	    }
	}

	// Implantation d'un gestionnaire de mise en forme de type grille.
	// Une bordure de boutons inertes et invisibles est installee autour
	// de la grille de cellules pour des considerations esthetiques.
	final int dimension = resolution + 2;
	setLayout(new GridLayout(dimension, dimension, 0, 0));

	// Installation de la premiere ligne (bordure).
	for (int i = 0; i < dimension; i ++) {
	    final JButton bouton = new JButton();
	    bouton.setVisible(false);
	    bouton.setEnabled(false);
	    add(bouton);
	}

	// Installation de la grille de cellules. Le debut et la fin de
	// chaque ligne representent la bordure.
	for (int i = 0; i < resolution; i ++) {

	    // Bordure.
	    {
		final JButton bouton = new JButton();
		bouton.setVisible(false);
		bouton.setEnabled(false);
		add(bouton);
	    }

	    // Installation des cellules.
	    for (int j = 0; j < resolution; j ++) {
		add(cellules[i][j]);
	    }

	    // Bordure.
	    {
		final JButton bouton = new JButton();
		bouton.setVisible(false);
		bouton.setEnabled(false);
		add(bouton);
	    }

	}

	// Installation de la derniere ligne (bordure).
	for (int i = 0; i < dimension; i ++) {
	    final JButton bouton = new JButton();
	    bouton.setVisible(false);
	    bouton.setEnabled(false);
	    add(bouton);
	}

    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link ModeleGraphique#vue}.
     */
    public Vue lireVue() {
	return vue;
    }

    /**
     * Met a jour toutes les cellules de ce modele.
     *
     * @note cette methode ne doit etre invoquee que lorsque qu'un verrou est
     *   place sur la vue proprietaire.
     */
    protected void mettreAJour() {
	for (int i = 0; i < cellules.length; i ++) {
	    for (int j = 0; j < cellules.length; j ++) {
		cellules[i][j].mettreAJour();
	    }
	}
    }

    /**
     * Affiche la mosaique de fond d'ecran.
     *
     * @param gc le contexte graphique fourni par la librairie graphique.
     */
    protected void afficherMosaique(Graphics gc) {
	final Dimension dimension = getSize();
	final int largeur = mosaique.getWidth(null);
	final int hauteur = mosaique.getHeight(null);
	int ligne = 0;
	int colonne = 0;
	while (ligne < dimension.height) {
	    while (colonne < dimension.width) {
		gc.drawImage(mosaique, colonne, ligne, null);
		colonne += largeur;
	    }
	    colonne = 0;
	    ligne += hauteur;
	}
    }

    @Override
    protected void paintComponent(Graphics gc) {
	super.paintComponent(gc);
	afficherMosaique(gc);
    }

    /**
     * Chemin d'acces relatif a la mosaique de fond.
     */
    protected static final String cheminMosaique = 
    	"ressources/images/mosaique.gif";

    /**
     * Mosaique de fond d'ecran.
     */
    protected static final Image mosaique;
    static {
	ClassLoader loader = ModeleGraphique.class.getClassLoader();
	URL url = loader.getResource(cheminMosaique);
	mosaique = (new ImageIcon(url)).getImage();
    }

    /**
     * Vue proprietaire de ce modele.
     */
    protected final Vue vue;

    /**
     * Grille de cellules graphiques.
     */
    protected final CelluleGraphique[][] cellules;

}