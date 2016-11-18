package grenouilloland.modele;

/**
 * Type enumere fortement type representant un pion.
 */
public enum Etat {
    Dead,          /** 0) Pion associe au premier joueur.               */
    Bad,         /** 1) Pion associe au second joueur.                */
    Good           /** 2) Pion special symbolisant un emplacement vide. */
}