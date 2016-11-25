package grenouilloland.vue;

import grenouilloland.modele.Modele;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class TimerDeJeu implements ActionListener{

    public TimerDeJeu(Vue vue, int temps){
        this.temps=temps;
        this.vue=vue;
    }


    public void demarrer(){
        timer.start();
    }

    public void arreter(){

        timer.stop();
    }



    protected Timer timer = new Timer(1000,this);




    @Override
    public void actionPerformed(ActionEvent e) {
        temps--;
        vue.cbTimer(temps);
        if(temps==0){
            vue.afficherFin();
        }
    }

    protected int temps;

    protected Vue vue;
}
