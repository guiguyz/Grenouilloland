package grenouilloland.vue;


import grenouilloland.modele.Position;
import grenouilloland.presentateur.Presentateur;

import javax.swing.JPanel;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Dimension;


/**
 * Representation graphique du modele.
 *
 * @author Alexis Prevost Maynen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
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

        // Creation du plateau de cases graphiques.
        {
            cases = new CaseGraphique[resolution][resolution];
            for (int i = 0; i < resolution; i++) {
                for (int j = 0; j < resolution; j++) {
                    cases[i][j] = new CaseGraphique(this, new Position(resolution-i-1, j));
                }
            }
        }

        // Implantation d'un gestionnaire de mise en forme de type grille.
        // Une bordure de boutons inertes et invisibles est installee autour
        // de la grille de cellules pour des considerations esthetiques.
        setLayout(new GridLayout(resolution, resolution, 0, 0));

        // Installation de la grille de cellules. Le debut et la fin de
        // chaque ligne representent la bordure.
        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                add(cases[i][j]);
            }
        }

    mettreAJour();
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
     * Affiche la mosaique de fond d'ecran.
     *
     * @param gc le contexte graphique fourni par la librairie graphique.
     */
    protected void afficherMosaique(Graphics gc) {
        final Dimension dimension = getSize();
        final int largeur = mosaique.getWidth(null);//null
        final int hauteur = mosaique.getHeight(null);//null
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
     * Mide a jour des cases du modele graphique.
     */
    public void mettreAJour(){
        // Obtention de la resolution du modele.
        final int resolution = vue.lirePresentateur().resolution();
        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                cases[i][j].mettreAJour();
            }

        }

    }


    /**
     * Chemin d'acces relatif a l'eau.
     */
    protected static final String cheminEau =
            "ressources/images/mosaique.jpg";

    /**
     * Mosaique de fond d'ecran.
     */
    protected static final Image mosaique;

    static {
        ClassLoader loader = ModeleGraphique.class.getClassLoader();
        URL url = loader.getResource(cheminEau);
        mosaique = (new ImageIcon(url)).getImage();
    }



    /**
     * Vue proprietaire de ce modele.
     */
    protected final Vue vue;

    /**
     * Plateau compose de case graphiques.
     */
    protected final CaseGraphique[][] cases;

}