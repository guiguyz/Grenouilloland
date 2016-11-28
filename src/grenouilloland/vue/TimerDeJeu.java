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
        //vie.mettreAJour();
        if(temps==0){
            vue.afficherFin();
            vue.cbReinitialiser();
        }
    }

    protected int temps;

    protected Vue vue;

    protected Vie vie;

}
