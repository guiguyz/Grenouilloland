package grenouilloland.vue;

import grenouilloland.presentateur.Presentateur;

/**
 *
 */
public class Threader extends Thread {

    public Threader(Vue vue, Presentateur presentateur){
        this.vue=vue;
        this.presentateur=presentateur;
    }

    @Override
    public void run(){
        try
        {
            while (vue.partieLancee){
                vue.mettreAJour();
                // Exécution de la tâche
                presentateur.vieillirNenuphar();
                // En pause pour une seconde
                Thread.sleep (1000);
            }
        }
        catch (InterruptedException exception){}
    }

    protected Presentateur presentateur;

    protected Vue vue;


}
