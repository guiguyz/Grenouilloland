package grenouilloland.vue;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.net.URL;
import java.awt.event.ActionEvent;

/**
 * Classe representant une action consistant a reinitialiser le jeu.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
class ActionNouveau extends ActionAbstraite {

    /**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionNouveau(Vue vue) {
	super(texte, 
	      icone,
	      aide,
	      mnemonique,
	      accelerateur,
	      vue);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
	vue.cbReinitialiser();
    }//

    /**
     * Texte de cette action.
     */
    protected static final String texte = "Nouveau";

    /**
     * Chemin d'acces relatif a l'icone de cette action.
     */
    protected static final String cheminIcone = 
    	"ressources/images/nouveau.png";

    /**
     * Icone de cette action.
     */
    protected static final ImageIcon icone;
    static {
	ClassLoader loader = ActionNouveau.class.getClassLoader();
	URL url = loader.getResource(cheminIcone);
	icone = new ImageIcon(url);
    }

    /**
     * Texte de la bulle d'aide de cette action.
     */
    protected static final String aide = "Réinitialiser le jeu.";

    /**
     * Mnemonique de cette action.
     */
    protected static final int mnemonique = KeyEvent.VK_N;

    /**
     * Accelerateur de cette action.
     */
    protected static final KeyStroke accelerateur = 
    	KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK);

}