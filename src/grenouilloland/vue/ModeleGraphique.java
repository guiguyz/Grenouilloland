package grenouilloland.vue;


import grenouilloland.modele.Position;
import grenouilloland.presentateur.Presentateur;

import javax.swing.JPanel;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
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

        // Creation du plateau de cases graphiques.
        {
            cases = new CaseGraphique[resolution][resolution];
            int rangCouleur;
            for (int i = 0; i < resolution; i++) {
                rangCouleur = i % 2;
                for (int j = 0; j < resolution; j++) {
                    cases[i][j] = new CaseGraphique(this, new Position(i, j));
                    //cases[i][j].setIcon(new ImageIcon(cheminEau));
                    cases[i][j].setBackground(couleurs[rangCouleur]);
                    rangCouleur = (rangCouleur + 1) % couleurs.length;
                }
            }
        }

        // Implantation d'un gestionnaire de mise en forme de type grille.
        // Une bordure de boutons inertes et invisibles est installee autour
        // de la grille de cellules pour des considerations esthetiques.
        final int dimension = resolution + 2;
        setLayout(new GridLayout(dimension, dimension, 0, 0));

        // Installation de la premiere ligne (bordure).
        for (int i = 0; i < dimension; i++) {
            final JButton bouton = new JButton();
            bouton.setVisible(false);
            bouton.setEnabled(false);
            add(bouton);
        }

        // Installation de la grille de cellules. Le debut et la fin de
        // chaque ligne representent la bordure.
        for (int i = 0; i < resolution; i++) {

            // Bordure.
            {
                final JButton bouton = new JButton();
                bouton.setVisible(false);
                bouton.setEnabled(false);
                add(bouton);
            }

            // Installation des cases du plateau.
            for (int j = 0; j < resolution; j++) {
                add(cases[i][j]);
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
        for (int i = 0; i < dimension; i++) {
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
     * Chemin d'acces relatif a la mosaique de fond.
     */
    protected static final String cheminMosaique =
            "ressources/images/mosaique.gif";

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
        URL url = loader.getResource(cheminMosaique);
        mosaique = (new ImageIcon(url)).getImage();
    }

    /**
     * Les deux couleurs de cases du plateau.
     */
    protected static final Color[] couleurs = {// eau ou nenuphar
            Color.darkGray,
            Color.lightGray
    };

    /**
     * Chemin d'acces relatif au repertoire contenant les images des pions des
     * deux joueurs.
     */
    protected static final String cheminPions = "ressources/images/";


    /**
     * Vue proprietaire de ce modele.
     */
    protected final Vue vue;

    /**
     * Plateau compose de case graphiques.
     */
    protected final CaseGraphique[][] cases;

}