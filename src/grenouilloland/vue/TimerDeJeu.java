package grenouilloland.vue;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class TimerDeJeu implements ActionListener{

    public TimerDeJeu(Vue vue){
        temps=59;
        this.vue=vue;
    }


    public void demarrer(){
        timer.start();
    }

    public void arreter(){ timer.stop(); }



    protected Timer timer = new Timer(1000,this);




    @Override
    public void actionPerformed(ActionEvent e) {
        temps--;
        vue.cbTimer(temps);
        if(temps==0){
            vue.presentateur.getGrenouille().setPtVie(-1);
            vue.afficherFin();
            vue.cbReinitialiser();
        }
    }

    public void resetTemps(){
        temps=59;
    }

    protected int temps;

    protected Vue vue;

}
