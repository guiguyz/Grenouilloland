package grenouilloland.vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * Classe representant une action consistant a lancer une partie de jeu.
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public class ActionLancer extends ActionAbstraite {

    /**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionLancer(Vue vue) {
        super(texte,
                icone,
                aide,
                mnemonique,
                accelerateur,
                vue);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        vue.cbLancer();
    }//

    /**
     * Texte de cette action.
     */
    protected static final String texte = "Lancer";

    /**
     * Chemin d'acces relatif a l'icone de cette action.
     */
    protected static final String cheminIcone =
            "ressources/images/lancer.png";

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
    protected static final String aide = "Lancer une partie.";

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
