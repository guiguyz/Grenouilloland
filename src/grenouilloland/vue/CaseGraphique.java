package grenouilloland.vue;

import grenouilloland.modele.*;
import grenouilloland.presentateur.Presentateur;

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
        //setIcon(new ImageIcon(eauIcone));
        //vie.mettreAJour();


        if(position.estEgale(posGrenouille)){

            //setIcon(grenouilleIcone);
            setText("G "+grenouille.getEtat().name()+" "+grenouille.getPtVie());
        }
        else{
            //setIcon(nenupharsIcons[0][couleurSurface.get(nenuphar.getType())]);
            setText(typeNenuphar.name()+" "+nenuphar.getAge());

        }

    }







    /**
     * Representation graphique du modele proprietaire de cette case.
     */
    protected final ModeleGraphique modeleGraphique;

    /**
     * Position de la cellule du modele correspondante.
     */
    protected final Position position;



    protected static final String dossierImages = "ressources/images/";

    /**
     * Chemin d'acces relatif a la grenouille.
     */
    protected static final String grenouilleChemin =
            dossierImages+"grenouille-verte-96x57.png";




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






}