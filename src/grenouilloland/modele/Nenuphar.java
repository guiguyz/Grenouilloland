package grenouilloland.modele;

/**
 * Permet de construire un nenuphar
 *
 * @note par defaut construit de l'eau
 *
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public class Nenuphar {


    /**
     * Constructeur logique.
     *
     * @param type le type de nenuphar
     */
    public Nenuphar(TypeElement type){
        this.type=type;
        this.age=age.GRAND;
    }

    /**
     *
     * Constructeur par defaut.
     *
     * definnisant un nenuphar de base
     * comme étant de l'eau
     * et comme etant toujours grand.
     */
    public Nenuphar(){//
        this.type=type.EAU;
        this.age=age.GRAND;
    }




    /**
     * vieillir un nenuphar.
     *
     * vieillis tout type de nenuphar excepté l'eau
     * et les nenuphar immortel
     *
     */
    public void vieillir() {
        if (getAge() == age.GRAND) {
            setAge(age.MOYEN);
        } else if (getAge() == age.MOYEN) {
            setAge(age.PETIT);
        } else {
            setAge(age.GRAND);
            setType(type.EAU);
        }
    }

    /**
     * Accesseur.
     *
     * @return retourne le type d'un nenuphar.
     */
    public TypeElement getType() {
        return type;
    }

    /**
     * Accesseur.
     *
     * @return retourne l'age d'un nenuphar.
     */
    public Age getAge() {
        return age;
    }

    /**
     * Mutateur.
     *
     * @param age modifie l'age d'un nenuphar.
     */
    public void setAge(Age age) {
        this.age = age;
    }


    /**
     * Mutateur.
     *
     * @param type modifie le type d'un nenuphar.
     */
    public void setType(TypeElement type) {
        this.type = type;
    }

    /**
     * type d'un nenuphar.
     */
    protected TypeElement type;

    /**
     * age d'un nenuphar.
     */
    protected Age age;
}
