package grenouilloland.vue;

import grenouilloland.modele.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.HashMap;

/**
 * Representation graphique d'une case du plateau de jeu.
 *
 * @note Chaque instance de cette classe represente son propre listener.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
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


	//Rend transparent les JButton, pour afficher la mosaique d'eau.
    setContentAreaFilled(false);
    setBorderPainted(false);


    //Dimensionne les JButton au démarage
    setPreferredSize(new Dimension(200, 150));

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
     * A la seule exception du constructeur logique, toute invocation
     *   de cette methode ne doit etre realisee que si un verrou est pose sur
     *   la vue.
     */
    protected void mettreAJour() {
		
        // Obtention de la vue proprietaire du modele graphique.
        final Vue vue = modeleGraphique.lireVue();
        Grenouille grenouille=vue.lirePresentateur().getGrenouille();
        Nenuphar nenuphar=vue.lirePresentateur().getNenuphar(position);
        Position posGrenouille=vue.lirePresentateur().getGrenouille().getPosition();
        TypeElement typeNenuphar=nenuphar.getType();
        //couleurSurface.get(typeNenuphar)

        if(position.estEgale(posGrenouille)){
            setIcon(new ImageIcon(grenouilleIcone));
            //setText("G "+grenouille.getEtat().name()+" "+grenouille.getPtVie());
        }
        else if(vue.lireType(position)==typeNenuphar && vue.lireType(position)==TypeElement.NENUPHARIMMORTEL ) {
            setIcon(new ImageIcon(nenupharIcone));
        }

        else if(vue.lireType(position)==typeNenuphar && vue.lireType(position)!=TypeElement.EAU ){
            //setIcon(new ImageIcon(nenupharsIcons[3][0].getImage()));
            setIcon(new ImageIcon(nenupharRose));
            //setText(typeNenuphar.name()+" "+nenuphar.getAge());

        }
        else setIcon(null);
    }

    /**
     * Grenouille Image.
     */
    protected static final Image nenupharIcone;

    static {
        ClassLoader loader = ModeleGraphique.class.getClassLoader();
        URL url = loader.getResource("ressources/images/grand-nenuphare-vert-96x96.png");
        nenupharIcone = (new ImageIcon(url)).getImage();
    }

    /**
     * Nenuphar immortel Image.
     */
    protected static final Image nenupharRose;

    static {
        ClassLoader loader = ModeleGraphique.class.getClassLoader();
        URL url = loader.getResource("ressources/images/grand-nenuphare-rose-96x96.png");
        nenupharRose = (new ImageIcon(url)).getImage();
    }




    /**
     * Les différentes couleurs que peuvent prendre les nénuphars
     *
     */
    protected static final String[] couleurs = {"rouge", "vert", "jaune", "rose"};



    /**
     * Representation graphique du modele proprietaire de cette case.
     */
    protected final ModeleGraphique modeleGraphique;

    /**
     * Position de la cellule du modele correspondante.
     */
    protected final Position position;

    /**
     * Le dossier contenant toutes les images
     */
    protected static final String dossierImages = "ressources/images/";


    /**
     * Chemin d'acces relatif a la grenouille.
     */
    protected static final String grenouilleChemin = dossierImages+"grenouille-verte-96x57.png";

//
//    /*
//     * Les différentes tailles que peuvent prendre les nénuphars
//     */
//    protected static final String[] tailles = {"grand", "moyen", "petit"};//age
//
//    /** Les différentes couleurs que peuvent prendre les nénuphars */
//    protected static final String[] couleurNenuphar = {"jaune", "rose", "rouge", "vert"};
//
//
//
//
//    /*
//    * Tableau contenant toutes les images des nénuphars
//    */
//    protected static final ImageIcon[][] nenupharsIcons;
//    static{
//        // Crée le tableau d'images à 2 dimensions et charge chacune
//        //    des images dans ce tableau.
//        nenupharsIcons = new ImageIcon[tailles.length][couleurNenuphar.length];//3,4
//        ClassLoader loader = ModeleGraphique.class.getClassLoader();
//        //ClassLoader loader = ActionQuitter.class.getClassLoader();
//
//        /*Pour chaque couleur et chaque taille de nénuphar, ainsi que
//         * pour chaque état de la grenouille, on charge l'image.
//         * Les noms d'image sont de la forme :
//         * taille-couleur.png
//         * */
//
//        for (int i = 0; i < tailles.length; i++) {
//            for (int j = 0; j < couleurNenuphar.length; j++) {
//                String chemin = dossierImages + "/" + tailles[i] + "-" + "nenuphare"+
//                        couleurNenuphar[j] + "-" + "96x96" + ".png";
//                URL urlImage = loader.getResource(chemin);
//                nenupharsIcons[i][j] = new ImageIcon(urlImage);
//            }
//        }
//    }
//
//    /**
//     * Hashmap contenant les équivalences ActionSurface-image.
//     * Elle permet d'associer à chaque type de nénuphar la couleur qui
//     * lui est associée
//     */
//    protected static final HashMap<TypeElement, Integer> couleurSurface;
//    static{
//        couleurSurface = new HashMap<TypeElement, Integer>();
//        couleurSurface.put(TypeElement.EAU, -1);
//        couleurSurface.put(TypeElement.NENUPHARIMMORTEL, 1);
//        couleurSurface.put(TypeElement.NENUPHAR, 1);
//        couleurSurface.put(TypeElement.NENUPHARDOPANT, 0);
//        couleurSurface.put(TypeElement.NENUPHARMORTEL, 0);
//        couleurSurface.put(TypeElement.NENUPHARNUTRITIF, 3);
//        couleurSurface.put(TypeElement.NENUPHARVENENEUX, 2);
//    }


    /**
     * Grenouille Image.
     */
    protected static final Image grenouilleIcone;

    static {
        ClassLoader loader = ModeleGraphique.class.getClassLoader();
        URL url = loader.getResource(grenouilleChemin);
        grenouilleIcone = (new ImageIcon(url)).getImage();
    }

    /**
     * Chemin d'acces relatif a la grenouille.
     */
    protected static final String eauChemin =
            dossierImages+"mosaique.jpg";

    /**
     * Eau.
     */
    protected static final Image eauIcone;

    static {
        ClassLoader loader = ModeleGraphique.class.getClassLoader();
        URL url = loader.getResource(eauChemin);
        eauIcone = (new ImageIcon(url)).getImage();
    }

    protected Vie vie;

}