package grenouilloland.vue;


import grenouilloland.modele.Position;
import grenouilloland.presentateur.Presentateur;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JOptionPane;

/**
 * Classe representant la vue.
 */
public class Vue extends JFrame {

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Vue#titre}.
     */
    public static String lireTitre() {
        return titre;
    }

    /**
     * Constructeur logique.
     *
     * @param presentateur la valeur de {@link Vue#presentateur}.
     */
    public Vue(Presentateur presentateur) {

        // Recopie des arguments.
        this.presentateur = presentateur;

        // Instanciation de l'action "Quitter".
        actionQuitter = new ActionQuitter(this);

        // Titre de la fenetre principale.
        setTitle(titre);
        //setSize(1000,600);

        // Construction de la barre de menus et d'outils.
        contruireBarresMenusEtOutils();

        // Instanciation du modele graphique et implantation a la position
        // center du gestionnaire de mise en forme par defaut.
        modeleGraphique = new ModeleGraphique(this);
        add(modeleGraphique, BorderLayout.CENTER);

        // Instanciation de la barre de defilement controlant la resolution et
        // implantation dans la partie south du gestionnaire de mise en forme
        // par defaut.
        final Resolution resolution =
                new Resolution(JScrollBar.HORIZONTAL, this);
        add(resolution, BorderLayout.SOUTH);

        // Positionnement initial de la fenetre au milieu de l'écran.
        setLocationRelativeTo(null);


        // Comportement par defaut en cas de suppression de la fenetre : tout
        // doit passer par l'action "Quitter".
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                actionQuitter.dernierArretAvantSortie();
            }
        });

    }

    /**
     * Accesseur.
     *
     * @return la valeur de {@link Vue#presentateur}.
     */
    public Presentateur lirePresentateur() {
        return presentateur;
    }

    /**
     * Construit la barre de menus et d'outils et les implante a la position
     * nord du gestionnaire de mise en forme par defaut.
     */
    protected void contruireBarresMenusEtOutils() {

        // Instanciation des barres de menus et d'outils.
        final JMenuBar barreMenus = new JMenuBar();
        final JToolBar barreOutils = new JToolBar();
        final Vie vie = new Vie();


        // Creation du menu et definition de sa mnemonique.
        final JMenu menu = new JMenu("Commandes");
        menu.setMnemonic('C');

        // Instanciation de l'action "Nouveau" puis ajout dans le menu.
        final ActionNouveau actionNouveau = new ActionNouveau(this);
        menu.add(actionNouveau);

        // Instanciation de l'action "Lancer" puis ajout dans le menu.
        final ActionLancer actionLancer = new ActionLancer(this);
        menu.add(actionLancer);

        // Instanciation de l'action "A propos ..." puis ajout  dans le menu.
        final ActionAPropos actionAPropos = new ActionAPropos(this);
        menu.add(actionAPropos);

        // Implantation d'un separateur dans le menu.
        menu.addSeparator();

        // Ajout de l'action "Quitter" dans le menu.
        menu.add(actionQuitter);

        // Ajout de l'action "Nouveau" dans la barre d'outils.
        barreOutils.add(actionNouveau);

        // Ajout de l'action "Nouveau" dans la barre d'outils.
        barreOutils.add(actionLancer);

        // Ajout de l'action "A propos ..." dans la barre d'outils.
        barreOutils.add(actionAPropos);

        // Ajout d'un separateur dans la barre d'outils.
        barreOutils.addSeparator();

        // Ajout de l'action "Quitter" dans la barre d'outils.
        barreOutils.add(actionQuitter);

        // Inscription du menu dans sa barre.
        barreMenus.add(menu);

        // Implantation de la barre de menus sous le titre de la fenetre.
        setJMenuBar(barreMenus);

        // Implantation de la barre d'outils dans le gestionnaire de mise en
        // forme par defaut.
        add(barreOutils, BorderLayout.NORTH);
        add(vie, BorderLayout.WEST);
    }

    /**
     * Callback permettant de changer le modele.
     *
     * @param resolution la resolution du nouveau modele.
     * @note cette methode pose un verrou sur la vue pendant tout la duree
     * de son execution.
     */
    protected synchronized void cbNouveauModele(int resolution) {
        reinitialiser(resolution);
    }


    /**
     * Callback permettant de lancer Une Partie.
     *
     *
     * @note cette methode pose un verrou sur la vue pendant tout la duree
     * de son execution.
     */
    protected synchronized void cbLancer() {
        //lancer le timer de 60s
        //lancer le timer de 1s
        presentateur.genereCheminNenuphar();
        modeleGraphique.mettreAJour();

    }

    /**
     * Callback permettant de déplacer la grenouille.
     *
     * @param caseGraphique la case graphique a l'origine de la requete.
     * @note cette methode pose un verrou sur la vue pendant tout la duree
     * de son execution.
     */
    protected synchronized void cbPoser(CaseGraphique caseGraphique) {

        // Obtention de la position de la case correspondante dans le modele.
        final Position position = caseGraphique.lirePosition();
        presentateur.deplacerGrenouille(position);

        // Obtention du pion du joueur courant.
        //final Pion pion = modeleGraphique.lireCourant();

        // Requete au presentateur pour poser le pion.
        //final Resultat resultat = presentateur.jouer(pion, position);


        // Sinon, mettre a jour la case graphique.
        //caseGraphique.mettreAJour();
        presentateur.genereCheminNenuphar();
        modeleGraphique.mettreAJour();


    }

    /**
     * Callback permettant de reinitialiser le jeu.
     */
    protected synchronized void cbReinitialiser() {
        reinitialiser(presentateur.resolution());
    }

    /**
     * Affiche un requester avec un message.
     *
     * @param message le message.
     */
    protected void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "le message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Reinitialise le jeu en remplacant le modele actuel.
     *
     * @param resolution la resolution souhaitee.
     * @note cette methode ne peut etre invoquee que si un verrou est placee
     * sur la vue.
     */
    protected void reinitialiser(int resolution) {

        // Requete au presentateur pour instancier un nouveau modele.
        presentateur.nouveauModele(resolution);

        // Suppression de l'ancien modele graphique du gestionnaire de mise
        // en forme par defaut.
        remove(modeleGraphique);

        // Instanciation du nouveau modele graphique et implantation a la
        // position center du gestionnaire de mise en forme par defaut.
        modeleGraphique = new ModeleGraphique(this);
        add(modeleGraphique, BorderLayout.CENTER);

        // Calcul des nouvelles dimensions de chaque composant et reaffichage
        // de la vue.
        validate();
        repaint();

    }

    /**
     * Titre de cette vue.
     */
    protected static final String titre = "Grenouilloland";

    /**
     * Presentateur de cette vue.
     */
    protected final Presentateur presentateur;

    /**
     * Action permettant de quitter proprement l'application.
     */
    protected final ActionQuitter actionQuitter;

    /**
     * Modele graphique de cette vue.
     */
    protected ModeleGraphique modeleGraphique;

}