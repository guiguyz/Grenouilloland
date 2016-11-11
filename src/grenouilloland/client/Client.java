package grenouilloland.client;

import grenouilloland.presentateur.Presentateur;

/**
 * Classe representant le client de l'application, c'est a dire ici le
 * programme principal.
 */
public class Client {

    /**
     * Point d'entree de la JVM.
     *
     * @param args les arguments de la ligne de commandes.
     */
    public static void main(String[] args) {
	
	// La ligne de commandes est vide : l'utilisateur demande de l'aide.
	if (args.length == 0) {
	    final String message = "Usage: java Client resolution_min" +
		" resolution_max resolution";
	    System.out.println(message);
	    return;
	}

	// Le nombre d'arguments est different de trois : l'utilisateur fait
	// n'importe quoi.
	if (args.length != 3) {
	    System.err.println("Nombre d'arguments incorrect.");
	    return;
	}

	// Tentative d'extraction de la resolution minimum : il s'agit d'une 
	// operation a risque.
	final int resolutionMin;
	try {
	    resolutionMin = Integer.parseInt(args[0]);
	    if (resolutionMin <= 0) {
		throw new NumberFormatException();
	    }
	}
	catch (NumberFormatException e) {
	    final String message = "La résolution minimum n'est pas un " +
		"entier positif";
	    System.err.println(message);
	    return;
	}

	// Tentative d'extraction de la resolution maximum: il s'agit d'une
	// operation a risque.
	final int resolutionMax;
	try {
	    resolutionMax = Integer.parseInt(args[1]);
	    if (resolutionMax < resolutionMin) {
		throw new NumberFormatException();
	    }
	}
	catch (NumberFormatException e) {
	    final String message = "La resolution maximum n'est pas un entier" +
		" supérieur ou égal a " + resolutionMin;
	    System.err.println(message);
	    return;	    
	}

	// Tentative d'extraction de la resolution initiale : il s'agit d'une
	// operation a risque.
	final int resolution;
	try {
	    resolution = Integer.parseInt(args[2]);
	    if (resolution < resolutionMin || resolution > resolutionMax) {
		throw new NumberFormatException();
	    }
	}
	catch (NumberFormatException e) {
	    final String message = "La resolution n'est pas un entier de " +
		"l'intervalle [" + resolutionMin + ", " + resolutionMax + "]";
	    System.err.println(message);
	    return;
	}
	

	// Tout est ok : instanciation du presentateur.
	final Presentateur presentateur = 
	    new Presentateur(resolutionMin, resolutionMax, resolution);

	// Demarrage du presentateur : nous n'avons plus rien a faire a partir
	// de maintenant.
	presentateur.demarrer();

    }

}