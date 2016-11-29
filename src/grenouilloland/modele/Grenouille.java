package grenouilloland.modele;

/**
 * Classe Grenouille.
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




    public Grenouille()
    {
        this.etat=etat.Good;

        this.position=new Position(0,0);

        this.ptVie = 2;
    }

    public int getPtVie()
    {
        return ptVie;
    }

    public void setPtVie(int ptVie)
    {
        this.ptVie = ptVie;
        if (ptVie<=0) {
            mourir();
        }
    }

    public boolean estMalade(){
        return this.etat==etat.Bad;

    }

    public void rendreMalade(){ this.etat = etat.Bad; }

    public void guerir(){
        this.etat = etat.Good;
    }

    public void mourir()
    {
        this.etat=etat.Dead;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }


}