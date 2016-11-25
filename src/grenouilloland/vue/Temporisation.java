package grenouilloland.vue;

import javax.swing.*;


/**
 *
 */
public class Temporisation extends JProgressBar{



    public Temporisation(Vue vue){

        super(JProgressBar.HORIZONTAL, 0, 59);
        this.vue = vue;
        setValue(59);
        //mettreTempsAJour();
    }

    /**
     * Met à jour le chronomètre à partir du modèle.
     */
    protected void mettreTempsAJour(){
        setValue(0);
    }



    /**
     * Vue proprietaire de cette barre.
     */
    protected Vue vue;

}

