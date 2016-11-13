package grenouilloland.modele;

/**
 * Type enumere fortement type representant les types de resultats engendres
 * par un coup joue.
 */
public enum Resultat {
    Invalide,             /** Coup invalide.                */
    Gagnant,              /** Coup decisif.                 */
    NiInvalideNiGagnant,  /** Coup valide mais non decisif. */
}