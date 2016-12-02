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
 * @author Lucas Gouedard
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
     * @return la valeur de {@link CaseGraphique#position}.
     * */
    public Position lirePosition() {
	return position;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(modeleGraphique.lireVue().partieLancee){
            modeleGraphique.lireVue().cbPoser(this);
        }
    }

    /**
     * Met a jour l'icone de cette case graphique en fonction de la position de la grenouille
     * */
    protected void mettreAJour() {
		
        // Obtention de la vue proprietaire du modele graphique.
        final Vue vue = modeleGraphique.lireVue();
        Grenouille grenouille=vue.lirePresentateur().getGrenouille();
        Nenuphar nenuphar=vue.lirePresentateur().getNenuphar(position);
        Position positionGrenouille=vue.lirePresentateur().getGrenouille().getPosition();
        TypeElement typeNenuphar=nenuphar.getType();

        if(position.estEgale(positionGrenouille)){
            setIcon(grenouilleIcones[couleurGrenouille.get(grenouille.getEtat())]);
        }
        else if(vue.lireType(position)==typeNenuphar && vue.lireType(position)!=TypeElement.EAU) {
            setIcon(nenupharsIcons[ageNenuphars.get(nenuphar.getAge())][couleurNenuphars.get(nenuphar.getType())]);
        }
        else setIcon(null);
    }



    /**
     * Tableau contenant les differentes couleurs de la grenouille
     * */
    protected static final String[] etatGrenouille = {"noir","rouge", "verte"};

    /**
     * Tableau contenant toutes les images des grenouilles
     * */
    protected static final ImageIcon[] grenouilleIcones;
    static {

        // On crée le tableau d'images à 1 dimensions pour la grenouille
        grenouilleIcones = new ImageIcon[etatGrenouille.length];
        ClassLoader loader = ModeleGraphique.class.getClassLoader();

        // pour chaque état de la grenouille, on charge l'image.
        for (int i = 0; i < etatGrenouille.length; i++) {
            String chemin = "ressources/images/grenouille-" + etatGrenouille[i] + "-96x57.png";
            URL urlImage = loader.getResource(chemin);
            grenouilleIcones[i] = new ImageIcon(urlImage);
        }
    }

    /**
     * Hashmap contenant les équivalences TypeElement-image.
     * Elle permet d'associer à la grenouille la couleur qui
     * lui est associée en fonction de son etat
     * */
    protected static final HashMap<Etat, Integer> couleurGrenouille;
    static{
        couleurGrenouille = new HashMap<>();
        couleurGrenouille.put(Etat.MORTE, 0);
        couleurGrenouille.put(Etat.MALADE, 1);
        couleurGrenouille.put(Etat.VIVANTE, 2);
    }


    /**
     * Les différentes tailles que peuvent prendre les nénuphars
     * */
    protected static final String[] tailleNenuphar = {"grand", "moyen", "petit"};



    /**
     * Les différentes couleurs que peuvent prendre les nénuphars
     * */
    protected static final String[] couleurNenuphar = {"jaune", "rose", "rouge", "vert"};

    /**
     * Hashmap contenant les équivalences TypeElement-image.
     * Elle permet d'associer à chaque type de nénuphar la couleur qui
     * lui est associée
     * */
    protected static final HashMap<TypeElement, Integer> couleurNenuphars;
    static{
        couleurNenuphars = new HashMap<>();
        couleurNenuphars.put(TypeElement.EAU, -1);
        couleurNenuphars.put(TypeElement.NENUPHARIMMORTEL, 3);
        couleurNenuphars.put(TypeElement.NENUPHAR, 3);
        couleurNenuphars.put(TypeElement.NENUPHARDOPANT, 2);
        couleurNenuphars.put(TypeElement.NENUPHARMORTEL, 2);
        couleurNenuphars.put(TypeElement.NENUPHARNUTRITIF, 1);
        couleurNenuphars.put(TypeElement.NENUPHARVENENEUX, 0);
    }

    /**
     * Hashmap contenant les équivalences Age-image.
     * Elle permet d'associer à chaque type de nénuphar la taille qui
     * lui est associée
     * */
    protected static final HashMap<Age, Integer> ageNenuphars;
    static{
        ageNenuphars = new HashMap<>();
        ageNenuphars.put(Age.GRAND, 0);
        ageNenuphars.put(Age.MOYEN, 1);
        ageNenuphars.put(Age.PETIT, 2);
    }





    /**
     * Tableau contenant toutes les images des nénuphars
     * */
    protected static final ImageIcon[][] nenupharsIcons;
    static{

        // Crée le tableau d'images à 2 dimensions pour les nenuphars
        nenupharsIcons = new ImageIcon[tailleNenuphar.length][couleurNenuphar.length];//3,4
        ClassLoader loader = ModeleGraphique.class.getClassLoader();

        //Pour chaque couleur et chaque taille de nénuphar
        //Les noms d'image sont de la forme :
        //taille-nenuphare-couleur-96x96.png
        for (int i = 0; i < tailleNenuphar.length; i++) {
            for (int j = 0; j < couleurNenuphar.length; j++) {
                String chemin = "ressources/images/" + tailleNenuphar[i] + "-nenuphare-"+
                        couleurNenuphar[j] + "-96x96.png";
                URL urlImage = loader.getResource(chemin);
                nenupharsIcons[i][j] = new ImageIcon(urlImage);
            }
        }
    }

    /**
     * Representation graphique du modele proprietaire de cette case.
     * */
    protected final ModeleGraphique modeleGraphique;

    /**
     * Position de la cellule du modele correspondante.
     * */
    protected final Position position;


}