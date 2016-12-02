package grenouilloland.vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

/**
 * Classe permettant d'afficher une aide dans le jeu.
 *
 * @author Alexis Prevost Maynen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 */
public class ActionAide extends ActionAbstraite {

    /**
     * Constructeur logique.
     *
     * @param vue la valeur de {@link ActionAbstraite#vue}.
     */
    public ActionAide(Vue vue) {
        super(texte,
                icone,
                aide,
                mnemonique,
                accelerateur,
                vue);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(vue,
                message,
                (String)getValue(Action.NAME),
                JOptionPane.INFORMATION_MESSAGE,
                (ImageIcon)getValue(Action.SMALL_ICON));
    }

    /**
     * Texte de cette action.
     */
    protected static final String texte = "Aide";

    /**
     * Chemin d'acces relatif a l'icone de cette action.
     */
    protected static final String cheminIcone =
            "ressources/images/aide.png";

    /**
     * Icone de cette action.
     */
    protected static final ImageIcon icone;
    static {
        ClassLoader loader = ActionAPropos.class.getClassLoader();
        URL url = loader.getResource(cheminIcone);
        icone = new ImageIcon(url);
    }

    /**
     * Texte de la bulle d'aide de cette action.
     */
    protected static final String aide =
            "Aide pour le jeu.";

    /**
     * Mnemonique de cette action.
     */
    protected static final int mnemonique = KeyEvent.VK_P;

    /**
     * Accelerateur de cette action.
     */
    protected static final KeyStroke accelerateur =
            KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK);

    /**
     * Message de presentation de cette action.
     */
    protected final String message = "Aide\n" +
            "Eau : une grenouille qui tombe à l’eau meurt dévorée par l’un des nombreux brochets qui infestent\n" +
            "la mare. \n"+
            " \n"+
            "Nénuphar : de couleur verte, ce nénuphar n’a aucun effet sur la grenouille. \n"+
            " \n"+
            "Nénuphar vénéneux : de couleur jaune, il rend la grenouille malade et divise par deux \n"+
            "le nombre de ses points de vie. Si la grenouille était déjà malade alors elle meurt de	surinfection. \n"+
            " \n"+
            "Nénuphar nutritif : de couleur rose, il augmente le nombre de points de vie de la grenouille d’une\n" +
            "unité et la guérit si elle était malade. \n"+
            " \n"+
            "Nénuphar dopant : de couleur rouge, il double les points de vie de la grenouille et la guérit si elle\n" +
            "était malade. \n"+
            " \n"+
            "Nénuphar mortel : de même couleur que le nénuphar dopant (on ne peut pas les différencier), il\n" +
            "provoque la mort instantanée de la grenouille.\n"+
            " \n"+
            " ";


}
