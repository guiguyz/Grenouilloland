package grenouilloland.modele;

/**
 * Type enumere fortement type representant un vecteur direction dans un repere
 * cartesien.
 */
enum Direction {

    Nord(0, -1),       /** 0) Direction Nord.       */
    NordEst(+1, -1),   /** 1) Direction Nord-Est.   */
    Est(+1, 0),        /** 2) Direction Est.        */  
    SudEst(+1, +1),    /** 3) Direction Sud-Est.    */
    Sud(0, +1),        /** 4) Direction Sud.        */
    SudOuest(-1, +1),  /** 5) Direction Sud-Ouest.  */
    Ouest(-1, 0),      /** 6) Direction Ouest.      */  
    NordOuest(-1, -1); /** 7) Direction Nord-Ouest. */

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Direction#deltaLigne}.
     */
    public int lireDeltaLigne() {
	return deltaLigne;
    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Direction#deltaColonne}.
     */
    public int lireDeltaColonne() {
	return deltaColonne;
    }

    /**
     * Retourne le successeur de cette direction dans l'enumeration.
     *
     * @return le successeur de cette direction dans l'enumeration.
     */
    public Direction suivante() {
	return values()[(ordinal() + 1) % values().length];
    }

    /**
     * Retourne la direction opposee de cette direction dans l'enumeration.
     *
     * @return la direction opposee de cette direction dans l'enumeration.
     */
    public Direction opposee() {
	return values()[(ordinal() + 4) % values().length];
    }

    /**
     * Constructeur logique.
     *
     * @param deltaLigne la valeur de {@link Direction#deltaLigne}.
     * @param deltaColonne la valeur de {@link Direction#deltaColonne}.
     */
    private Direction(int deltaLigne, int deltaColonne) {
	this.deltaLigne = deltaLigne;
	this.deltaColonne = deltaColonne;
    }

    /**
     * Delta sur les lignes.
     */
    private int deltaLigne;

    /**
     * Delta sur les colonnes.
     */
    private int deltaColonne;

}