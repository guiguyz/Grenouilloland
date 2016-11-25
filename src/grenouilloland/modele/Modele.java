
package grenouilloland.modele;



/**
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
    }// retourne la posituion d'un nenuphar


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
            if(position.voisine(grenouille.getPosition())){
                grenouille.setPosition(position);
                grille.lireType(position).effetSurGrenouille(grenouille);
                //vieillirNenuphar();
            }

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
            //nenuphar.getAge();
            if (getNenuphar(positionLigne).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                grille.setElement(nenuphar, positionLigne);
            }
            if (getNenuphar(positionColone).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                grille.setElement(nenuphar, positionColone);
            }
        }



    }

    /**
     * Ne genere que les lignes et les colones de nenuphar sur l'eau.
     */
    public void genereNenupharHaut(){
        Position posGrenouille = grenouille.getPosition();

        for (int j = grille.getResolution()-1; j > 0; j--) {
            Position positionLigne = new Position(j,grille.getResolution()-1);
            Position positionColone = new Position(grille.getResolution()-1,j);
            if (getNenuphar(positionLigne).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                grille.setElement(nenuphar, positionLigne);
            }
            if (getNenuphar(positionColone).getType()==TypeElement.EAU){
                Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                grille.setElement(nenuphar, positionColone);
            }
        }


    }


    /**
     * Fait vieillir chaque nénuphar qui peut vieillir.
     */
    public void vieillirNenuphar() {
        for (int i = 0; i < grille.getResolution(); i++) {
            for (int j = 0; j < grille.getResolution(); j++) {
                Position position = new Position(i, j);
                nenuphar = getNenuphar(position);
                if ( (nenuphar.getType() != TypeElement.EAU) && (nenuphar.getType() != TypeElement.NENUPHARIMMORTEL) ) {
                    nenuphar.vieillir();
                }
                //}else if(nenuphar.getAge()==Age.PETIT && grenouille.getPosition()==getNenuphar(position))
            }
        }
    }

    public boolean partieFinie(){
        if(perdant()){
            return true;
        }
        if(gagnant()){
            return true;
        }
        return false;
    }

    public boolean perdant(){
        return grenouille.getPtVie()==0 || grille.lireType(grenouille.getPosition())==TypeElement.EAU;
    }

    public boolean gagnant(){
        return grenouille.getPosition().lireColonne()==grille.getResolution()-1 && grenouille.getPosition().lireLigne()==grille.getResolution()-1;
    }

    //atribut
    protected GrilleElement grille;
    protected Grenouille grenouille;
    protected Nenuphar nenuphar;




}
