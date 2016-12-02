package grenouilloland.vue;



import grenouilloland.modele.Position;
import grenouilloland.modele.TypeElement;
import grenouilloland.presentateur.Presentateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Classe representant la vue principale de grenouilloland.
 *
 * @author Alexis Prevost Maynen
 * @author Guillaume Drouart
 * @author Lucas Gouedard
 * @author Nicolas Vatel
 */
public class Vue extends JFrame {

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

        final JPanel barreBas = new JPanel();
        barreBas.setLayout(new GridLayout(2,1));

        // Instanciation de la barre de defilement controlant la resolution et
        // implantation dans la partie south du gestionnaire de mise en forme
        // par defaut.
        final Resolution resolution =
                new Resolution(JScrollBar.HORIZONTAL, this);

        // Instanciation de la barre de defilement controlant la resolution et
        // implantation dans la partie south du gestionnaire de mise en forme
        // par defaut.
        temporisation = new Temporisation(this);



        final JPanel barreResolution = new JPanel(new GridLayout(1,1));
        final JPanel barreTimer = new JPanel(new GridLayout(1,1));

        barreResolution.setBorder(BorderFactory.createTitledBorder(
                " Changer résolution "));
        barreTimer.setBorder(BorderFactory.createTitledBorder(
                " Temps restant "));

        barreResolution.add(resolution);

        barreTimer.add(temporisation);

        barreBas.add(barreResolution);
        barreBas.add(barreTimer);
        add(barreBas, BorderLayout.SOUTH);

        // Obtenir la résolution de l'écran
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // Centrer la fenêtre dans l'écran
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        // Comportement par defaut en cas de suppression de la fenetre : tout
        // doit passer par l'action "Quitter".
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                actionQuitter.dernierArretAvantSortie();
            }
        });

        //thread timer de jeu
        timerDeJeu = new TimerDeJeu(this);



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

        //le panel de ne dois pas être final car on modifie la valeur de vie dans cbPoser()
        vie = new Vie(this);

        /* Menu */

        // Creation du menu et definition de sa mnemonique.
        final JMenu menu = new JMenu("Commandes");
        menu.setMnemonic('C');

        // Instanciation de l'action "Nouveau" puis ajout dans le menu.
        final ActionNouveau actionNouveau = new ActionNouveau(this);
        menu.add(actionNouveau);

        // Instanciation de l'action "Lancer" puis ajout dans le menu.
        final ActionLancer actionLancer = new ActionLancer(this);
        menu.add(actionLancer);

        // Instanciation de l'action "Aide" puis ajout dans le menu.
        final ActionAide actionAide = new ActionAide(this);
        menu.add(actionAide);

        // Instanciation de l'action "A propos ..." puis ajout  dans le menu.
        final ActionAPropos actionAPropos = new ActionAPropos(this);
        menu.add(actionAPropos);

        // Implantation d'un separateur dans le menu.
        menu.addSeparator();

        // Ajout de l'action "Quitter" dans le menu.
        menu.add(actionQuitter);


        /* Barre d'outils */

        // Ajout de l'action "Nouveau" dans la barre d'outils.
        barreOutils.add(actionNouveau);

        // Ajout de l'action "Nouveau" dans la barre d'outils.
        barreOutils.add(actionLancer);

        // Ajout de l'action "Aide" dans la barre d'outils.
        barreOutils.add(actionAide);

        // Ajout de l'action "A propos ..." dans la barre d'outils.
        barreOutils.add(actionAPropos);

        // Ajout d'un separateur dans la barre d'outils.
        barreOutils.addSeparator();

        // Ajout de l'action "Quitter" dans la barre d'outils.
        barreOutils.add(actionQuitter);

        // Ajout d'un separateur dans la barre d'outils.
        barreOutils.addSeparator();

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
    protected void cbNouveauModele(int resolution) {
        reinitialiser(resolution);
    }


    /**
     * Callback permettant de lancer Une Partie.
     */
    protected void cbLancer() {
        temporisation.mettreTempsAJour(59);
        partieLancee=true;
        presentateur.lancerPartie();
        timerDeJeu.demarrer();
        mettreAJour();
    }

    /**
     * Callback permettant de lancer un timer.
     *
     *@param temps La durée de partie
     */
    protected void cbTimer(int temps) {
        if (!partieLancee) {
            return;
        }
        presentateur.vieillirNenuphar();
        afficherFin();
        if(! partieLancee){
            return;
        }
        presentateur.genererChemin();
        temporisation.mettreTempsAJour(temps);
        mettreAJour();
    }

    /**
     * Callback permettant de déplacer la grenouille.
     *
     * @param caseGraphique la case graphique a l'origine de la requete.
     * @note cette methode pose un verrou sur la vue pendant tout la duree
     * de son execution.
     */
    protected void cbPoser(CaseGraphique caseGraphique) {

        // Obtention de la position de la case correspondante dans le modele.
        final Position position = caseGraphique.lirePosition();

        // Mise a jour de la case graphique si la partie est lancée.
        if (partieLancee){
            presentateur.deplacerGrenouille(position);
            mettreAJour();
            afficherFin();
            vie.mettreAJour();
        }
    }



    /**
     * Affiche un requester avec un message.
     *
     * @param message le message.
     */
    protected void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                titre,
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Callback permettant de reinitialiser le jeu.
     */
    protected void cbReinitialiser() {
        timerDeJeu.arreter();
        timerDeJeu.resetTemps();
        partieLancee=false;
        reinitialiser(presentateur.resolution());
        temporisation.mettreTempsAJour(59);
        vie.mettreAJour();
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
     * Mets a jour la valeur de la vie de la grenouille dans le panel de vie
     */
    public void mettreAJour(){
        modeleGraphique.mettreAJour();
    }

    /**
     * Affiche le message de fin de partie, qui peut être gagnante ou
     * perdante.
     */
    public void afficherFin(){
        if(!partieLancee){
            return;
        }
        // On prépare une nouvelle partie.

        final boolean gagnant = presentateur.gagnant();
        final boolean perdant = presentateur.perdant();

        if (! gagnant && ! perdant) { return; }
        timerDeJeu.arreter();
        partieLancee = false;
        if(gagnant) {
            afficherMessage("Bravo vous avez gagné");
        }
        if(perdant){
            afficherMessage("Dommage vous avez perdu");
        }
        cbReinitialiser();
    }

    /**
     * Retourne le contenu de la case dont la position est fournie en argument.
     *
     * @param position la position.
     * @return le contenu de la case correspondante.
     */
    public TypeElement lireType(Position position) {
        return presentateur.lireType(position);
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

    /**
     * Modele graphique de cette vue.
     */
    public boolean partieLancee=false;

    /**
     * Modele graphique de cette vue.
     */
    protected Temporisation temporisation;

    /**
     * Modele graphique de cette vue.
     */
    protected TimerDeJeu timerDeJeu;

    /**
     * Modele graphique de cette vue.
     */
    protected Vie vie;
}