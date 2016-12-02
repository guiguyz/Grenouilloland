package grenouilloland.vue;

import javax.swing.*;


/**
 * Classe permettant l'affichage graphique du temps restant de jeu.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 */
public class Temporisation extends JProgressBar{



    /**
     * Constructeur logique.
     *
     * @param vue la vue proprietaire de cette barre
     */
    public Temporisation(Vue vue){

        super(JProgressBar.HORIZONTAL, 0, 59);
        this.vue = vue;
        mettreTempsAJour(59);
    }

    /**
     * Met à jour le chronomètre à partir du modèle.
     */
    protected void mettreTempsAJour(int temps){
        setValue(temps);
    }



    /**
     * Vue proprietaire de cette barre.
     */
    protected Vue vue;

}

