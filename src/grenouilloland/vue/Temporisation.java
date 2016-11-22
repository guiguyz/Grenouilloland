package grenouilloland.vue;

import javax.swing.*;


/**
 *
 */
public class Temporisation extends JProgressBar{



    public Temporisation(Vue vue){

        super(JProgressBar.HORIZONTAL, 0, 9);
        this.vue = vue;

    }



    /**
     * Vue proprietaire de cette barre.
     */
    protected Vue vue;
}

