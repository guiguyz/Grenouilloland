/*   Grenouilloland is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package grenouilloland.modele;

import java.lang.Iterable;
import java.util.Iterator;

/**
 * Cette classe représente le modèle de l'application. Il contient une
 * grenouille et une mare, permettant de jouer à Grenouilloland.<br/>
 * Le but du jeu est d'arriver à amener la grenouille au coin opposé de
 * sa position de départ. Elle doit évoluer sur différentes surfaces,
 * qui ont un impact sur sa vie.
 *
 * @author
 * @author
 * @version 0.1
 */
public class Modele{

    public Modele(int resolution) {

        GrilleElement grille = new GrilleElement(resolution);

        Grenouille grenouille = new Grenouille();
    }


}
