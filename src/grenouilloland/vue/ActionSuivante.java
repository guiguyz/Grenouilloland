package grenouilloland.vue;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.net.URL;
import java.awt.event.ActionEvent;

/**
 * Classe representant une action permettant de calculer la generation suivante.
 */
class ActionSuivante extends ActionAbstraite {

    /**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionSuivante(Vue vue) {
	super(texte, 
	      icone,
	      aide,
	      mnemonique,
	      accelerateur,
	      vue);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
	vue.cbSuivante();
    }

    /**
     * Texte de cette action.
     */
    protected static final String texte = "Suivante";

    /**
     * Chemin d'acces relatif a l'icone de cette action.
     */
    protected static final String cheminIcone = 
    	"ressources/images/suivante.png";

    /**
     * Icone de cette action.
     */
    protected static final ImageIcon icone;
    static {
	ClassLoader loader = ActionSuivante.class.getClassLoader();
	URL url = loader.getResource(cheminIcone);
	icone = new ImageIcon(url);
    }

    /**
     * Texte de la bulle d'aide de cette action.
     */
    protected static final String aide = "Calculer la génération suivante.";

    /**
     * Mnemonique de cette action.
     */
    protected static final int mnemonique = KeyEvent.VK_S;

    /**
     * Accelerateur de cette action.
     */
    protected static final KeyStroke accelerateur = 
    	KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);

}