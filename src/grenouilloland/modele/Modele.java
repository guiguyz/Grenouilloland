
package grenouilloland.modele;


/**
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 * */
public class Modele{

    public Modele(int resolution) {

        grille = new GrilleElement(resolution);

        grenouille = new Grenouille();
    }

    // retourne la position d'un nenuphar
    public Nenuphar getNenuphar(Position position) {
        return grille.getNenuphar(position);
    }


    /**
     * Retourne la resolution de ce plateau.
     *
     * @return la resolution de ce plateau.
     */
    public int getResolution() {
        return grille.getResolution();
    }

    public void deplacerGrenouille(Position position){
            if(position.voisine(grenouille.getPosition())){
                grenouille.setPosition(position);
                grille.lireType(position).effetSurGrenouille(grenouille);
            }
    }

    public Grenouille getGrenouille() {
        return grenouille;
    }



    public void genereChemin(){

        Position posGrenouille = grenouille.getPosition();


        for (int i = posGrenouille.lireColonne()+1; i != grille.getResolution(); i++) {
            for (int j = posGrenouille.lireLigne()+1; j < grille.getResolution(); j++) {

                //ligne du bas
                Position positionColonneDebut = new Position(posGrenouille.lireLigne(),i);
                if (getNenuphar(positionColonneDebut).getType()==TypeElement.EAU){
                    Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                    grille.setElement(nenuphar, positionColonneDebut);
                }

                //colonne du debut
                Position positionLigneHaut = new Position(j,posGrenouille.lireColonne());
                if (getNenuphar(positionLigneHaut).getType()==TypeElement.EAU){
                    Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                    grille.setElement(nenuphar, positionLigneHaut);
                }

                //colonne de fin
                Position positionLigneBas = new Position(j,grille.getResolution()-1);
                if (getNenuphar(positionLigneBas).getType()==TypeElement.EAU){
                    Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                    grille.setElement(nenuphar, positionLigneBas);
                }

                //ligne du haut
                Position positionColonneFin = new Position(grille.getResolution()-1,i);
                if (getNenuphar(positionColonneFin).getType()==TypeElement.EAU){
                    Nenuphar nenuphar= new Nenuphar(TypeElement.auHasard());
                    grille.setElement(nenuphar, positionColonneFin);
                }
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
            }
        }
    }

    /**
     * Retourne le contenu de la case dont la position est fournie en argument.
     *
     * @param position la position.
     * @return le contenu de la case correspondante.
     */
    public TypeElement lireType(Position position) {
        return grille.lireType(position);
    }


    public boolean perdant(){
        return grenouille.getPtVie()==-1 || grille.lireType(grenouille.getPosition())==TypeElement.EAU;
    }

    public boolean gagnant(){
        Position positionGagnante = new Position(grille.getResolution() - 1, grille.getResolution() - 1);
        return grenouille.getPosition().estEgale(positionGagnante);
    }

    //atribut
    protected GrilleElement grille;
    protected Grenouille grenouille;
    protected Nenuphar nenuphar;





}
