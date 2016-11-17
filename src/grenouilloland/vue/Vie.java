package grenouilloland.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe Vie .
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
class Vie extends JPanel{

    private JPanel vie = new JPanel();

    /**
     * Constructeur logique du panneau de contrôle.
     *
     * @param vue La vue principale de l'application
     */
    public Vie(){
        vie.setPreferredSize(new Dimension(200, 500));
        vie.setBackground(Color.gray);
        add(vie, BorderLayout.WEST);

    }










}