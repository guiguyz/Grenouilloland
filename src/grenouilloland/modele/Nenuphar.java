package grenouilloland.modele;

/**
 * Nenuphar.
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public class Nenuphar {


    public Nenuphar(TypeElement type, Age age){
        this.type=type;
        this.age=age;
    }

    /**
     * Surcharge de constructeur definnisant un nenuphar de base comme étant de l'eau et comme etat toujours grand.
     *
     *
     */
    public Nenuphar(){//
        this.type=type.EAU;
        this.age=age.Grand;
    };



    public void viellir(){//


    }

    public TypeElement getType() {
        return type;
    }

    public Age getAge() {
        return age;
    }

    public void setType(TypeElement type) {
        this.type = type;
    }

    protected TypeElement type;
    protected Age age;
}
