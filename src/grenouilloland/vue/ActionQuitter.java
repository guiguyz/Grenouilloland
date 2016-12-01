package grenouilloland.vue;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.net.URL;
import java.awt.event.ActionEvent;

/**
 * Classe representant une action permettant de quitter proprement 
 * l'application.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
class ActionQuitter extends ActionAbstraite {

    /**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionQuitter(Vue vue) {
	super(texte, 
	      icone,
	      aide,
	      mnemonique,
	      accelerateur,
	      vue);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
	dernierArretAvantSortie();
    }

    /**
     * Dernier arret avant la sortie de l'application.
     */
    protected void dernierArretAvantSortie() {
	System.exit(0);
    }

    /**
     * Texte de cette action.
     */
    protected static final String texte = "Quitter";

    /**
     * Chemin d'acces relatif a l'icone de cette action.
     */
    protected static final String cheminIcone = 
    	"ressources/images/quitter.png";

    /**
     * Icone de cette action.
     */
    protected static final ImageIcon icone;
    static {
	ClassLoader loader = ActionQuitter.class.getClassLoader();
	URL url = loader.getResource(cheminIcone);
	icone = new ImageIcon(url);
    }

    /**
     * Texte de la bulle d'aide de cette action.
     */
    protected static final String aide = "Quitter l'application.";

    /**
     * Mnemonique de cette action.
     */
    protected static final int mnemonique = KeyEvent.VK_Q;

    /**
     * Accelerateur de cette action.
     */
    protected static final KeyStroke accelerateur = 
    	KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);

}