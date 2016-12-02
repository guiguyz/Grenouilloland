package grenouilloland.vue;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Thread de temporisation du jeu
 *
 * @author Alexis Prevost Maynen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 */
public class TimerDeJeu implements ActionListener{

    /**
     * Constructeur logique.
     *
     * @param vue la vue proprietaire de cette barre
     */
    public TimerDeJeu(Vue vue){
        temps=59;
        this.vue=vue;
    }


    /**
     * Demarre le timer.
     *
     */
    public void demarrer(){
        timer.start();
    }

    /**
     * Arrete le timer.
     */
    public void arreter(){ timer.stop(); }

    /**
     * Instancie un nouveau timer avec un délai de 1 seconde.
     */
    protected Timer timer = new Timer(1000,this);




    /**
     * Actualise toutes les 1 seconde le jeu,
     * tant que la partie n'est pas fini(gagner ou perdre)
     * ou que le temps restant est différents de 0.
     */
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

    /**
     * Reinitialise le temps à 59 secondes.
     */
    public void resetTemps(){
        temps=59;
    }

    /**
     * Temps de jeu.
     */
    protected int temps;

    /**
     * Modele graphique de cette vue.
     */
    protected Vue vue;

}
