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
                for(int i = 59; i >= 0; i--){

                    vue.mettreAJour();

                    tempsDeJeuRestant=i;

                    // Exécution de la tâche
                    presentateur.vieillirNenuphar();

                    // En pause pour une seconde
                    Thread.sleep (1000);
                }
            }
        }
        catch (InterruptedException exception){

        }
    }

    public int getTempsDeJeuRestant(){
        return tempsDeJeuRestant;
    }

    public int tempsDeJeuRestant;

    protected Presentateur presentateur;

    protected Vue vue;


}
