package grenouilloland.modele;

/**
 * Type enumere fortement type representant un pion.
 */
public enum Pion { 
    Croix,          /** 0) Pion associe au premier joueur.               */
    Cercle,         /** 1) Pion associe au second joueur.                */
    NiCroixNiCercle /** 2) Pion special symbolisant un emplacement vide. */
}