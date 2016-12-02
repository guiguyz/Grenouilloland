
package grenouilloland.modele;


/**
 *
 * @author Alexis Prevost Maynen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 * */
public class Modele{

    /**
     * Constructeur logique.
     *
     * @param resolution le modele prend une resolution pour la grille d'élément
     */
    public Modele(int resolution) {

        grille = new GrilleElement(resolution);

        grenouille = new Grenouille();
    }

    /**
     * Accesseur sur la position d'un nenuphar.
     *
     * @param position la position d'un nenuphar sur la grille d'élément
     * @return la position d'un nenuphar.
     */
    public Nenuphar getNenuphar(Position position) {
        return grille.getNenuphar(position);
    }


    /**
     * Accesseur sur la resolution d'une grille.
     *
     * @return la resolution d'une grille.
     */
    public int getResolution() {
        return grille.getResolution();
    }

    /**
     * Déplace la grenouille sur la grille.
     * Applique la strategie d'effet sur la grenouille.
     */
    public void deplacerGrenouille(Position position) {
        //Verifie si le déplacement est possible
        if (position.voisine(grenouille.getPosition())) {
            //met la grenouille sur la nouvelle position
            grenouille.setPosition(position);
            // en fonction du type de nenuphar ou est la grenouille
            // applique une effet sur celle si
            // qui correspond a la strategie d'effet
            grille.lireType(position).effetSurGrenouille(grenouille);
        }
    }

    /**
     * Retourne la grenouille.
     *
     * @return la grenouille.
     */
    public Grenouille getGrenouille() {
        return grenouille;
    }


    /**
     * Genere un chemin de nenupĥar au hasard sur de l'eau uniquement
     */
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
                //si le nenuphar n'est pas de l'eau ou n'est pas immortel alors viellir les nenuphars
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


    /**
     * Verifie si la grenouille perd.
     *
     * @return la grenouille perdante si ses points de vie sont a -1 ou si elle est sur de l'eau.
     */
    public boolean perdant(){
        return grenouille.getPtVie()==-1 || grille.lireType(grenouille.getPosition())==TypeElement.EAU;
    }

    /**
     * Verifie si la grenouille gagne.
     *
     * @return la position gagnante de la grenouille.
     */
    public boolean gagnant(){
        Position positionGagnante = new Position(grille.getResolution() - 1, grille.getResolution() - 1);
        return grenouille.getPosition().estEgale(positionGagnante);
    }

    /**
     * Grille d'element du modele.
     */
    protected GrilleElement grille;

    /**
     * Grenouille du modele.
     */
    protected Grenouille grenouille;

    /**
     * Nenuphar du modele.
     */
    protected Nenuphar nenuphar;





}
