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



    public void viellir(){
        if(!(this.type==type.EAU&&this.type==type.NENUPHARIMMORTEL)){
            if(this.age==age.Grand){
                this.age=age.Moyen;
            }
            else if(this.age==age.Moyen){
                this.age=age.Petit;
            }
            this.type=type.EAU;
        }
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
