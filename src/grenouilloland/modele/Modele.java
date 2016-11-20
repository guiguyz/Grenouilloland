
package grenouilloland.modele;



/**
 * Cette classe représente le modèle de l'application. Il contient une
 * grenouille et une mare, permettant de jouer à Grenouilloland.<br/>
 * Le but du jeu est d'arriver à amener la grenouille au coin opposé de
 * sa position de départ. Elle doit évoluer sur différentes surfaces,
 * qui ont un impact sur sa vie.
 *
 * @author
 * @author
 * @version 0.1
 */
public class Modele{

    public Modele(int resolution) {

        grille = new GrilleElement(resolution);

        grenouille = new Grenouille();
    }

    public Nenuphar getNenuphar(Position position) {
        return grille.getNenuphar(position);
    }

    public void viellirNenuphar() {
        nenuphar.viellir();
    }

    /**
     * Retourne la resolution de ce plateau.
     *
     * @return la resolution de ce plateau.
     */
    public int getResolution() {
        return grille.getResolution();
    }

/*    public GrilleElement getGrille() {
        return grille;
    }

    public void setGrille(GrilleElement grille) {
        this.grille = grille;
    }*/

    public void deplacerGrenouille(Position position){
        grenouille.setPosition(position);
    }

    public Grenouille getGrenouille() {
        return grenouille;
    }

    public void setGrenouille(Grenouille grenouille) {
        this.grenouille = grenouille;
    }


    public void genereCheminNenuphar(){
        Position posGrenouille = grenouille.getPosition();

        for (int i = 0; i < grille.getResolution(); i++) {
            Position positionLigne = new Position(i,posGrenouille.lireColonne());
            Position positionColone = new Position(posGrenouille.lireLigne(),i);
            if (getNenuphar(positionLigne).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionLigne);
            }
            if (getNenuphar(positionColone).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionColone);
            }
        }

        for (int j = grille.getResolution()-1; j > 0; j--) {
            Position positionLigne = new Position(j,grille.getResolution()-1);
            Position positionColone = new Position(grille.getResolution()-1,j);
            if (getNenuphar(positionLigne).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionLigne);
            }
            if (getNenuphar(positionColone).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard(), Age.Grand);
                grille.setElement(nenuphar, positionColone);
            }
        }
    }

    //atribut
    protected GrilleElement grille;
    protected Grenouille grenouille;
    protected Nenuphar nenuphar;



}
