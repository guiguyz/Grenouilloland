package grenouilloland.vue;

import javax.swing.*;


/**
 *
 */
public class Temporisation extends JProgressBar{



    public Temporisation(Vue vue){

        super(JProgressBar.HORIZONTAL, 0, 59);
        this.vue = vue;
        //setValue(59);

        mettreTempsAJour(59);
    }

    /**
     * Met à jour le chronomètre à partir du modèle.
     */
    protected void mettreTempsAJour(int temps){
        System.out.println(temps);
        setValue(temps);
    }



    /**
     * Vue proprietaire de cette barre.
     */
    protected Vue vue;

}

