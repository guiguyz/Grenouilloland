package grenouilloland.modele;

/**
 * Classe representant une grenouille ayant
 * un état, un nombre de points de vie et une
 * position sur la mare.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 */
public class Grenouille
{
    protected int ptVie;

    protected Position position;

    protected Etat etat;




    /**
     * Constructeur logique.
     */
    public Grenouille()
    {
        this.etat=etat.VIVANTE;

        this.position=new Position(0,0);

        this.ptVie = 1;
    }



    /**
     * Mutateur sur les points de vie de la grenouille
     *
     * Modifie les points de vie de la grenouille.
     */
    public void setPtVie(int ptVie)
    {
        this.ptVie = ptVie;

        //Si les points de vie sont inférieur à 0 alors la grenouille meurt.
        if (ptVie<0) {
            mourir();
        }
    }

    /**
     * Acceseur sur les points de vie de la grenouille
     *
     * @return les points de vie de la grenouille
     */
    public int getPtVie()
    {
        return ptVie;
    }

    /**
     * Verifie si la grenouille malade.
     *
     * @return si l'etat de la grenouille est malade.
     */
    public boolean estMalade(){
        return this.etat==etat.MALADE;

    }

    /**
     * Mutateur pour rendre malade la grenouille
     *
     * Modifie l'état de la grenouille en malade
     */
    public void rendreMalade(){ this.etat = etat.MALADE; }

    /**
     * Mutateur pour guerir la grenouille
     *
     * Modifie l'état de la grenouille en vivant
     */
    public void guerir(){
        this.etat = etat.VIVANTE;
    }

    /**
     * Mutateur pour tuer la grenouille
     *
     * Modifie l'état de la grenouille en morte
     */
    public void mourir()
    {
        this.etat=etat.MORTE;
    }

    /**
     * Acceseur sur la position de la grenouille
     *
     * @return la position de la grenouille.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Mutateur sur la position de la grenouille
     *
     * @param position la position de la grenouille
     * @return modifie la position de la grenouille
     */
    public void setPosition(Position position) {
        this.position = position;
    }


    /**
     * Acceseur sur l'etat de la grenouille
     *
     * @return l'etat de la grenouille
     */
    public Etat getEtat() {
        return etat;
    }

}