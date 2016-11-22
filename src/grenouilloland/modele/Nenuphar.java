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
        this.age=age.GRAND;
    };




    public void viellir(){
            if(this.age==age.GRAND){
                this.age=age.MOYEN;
            }
            else if(this.age==age.MOYEN){
                this.age=age.PETIT;
            }
            this.type=type.EAU;

    }

/*


    public void viellir(){
        if(!(type==type.EAU)&&!(type==type.NENUPHARIMMORTEL)){
            if(age.ordinal() < Age.values().length-1)){
                setAge(age.values()[age.ordinal()+1]);
            }
            setType(type.EAU);
        }
    }*/

    public TypeElement getType() {
        return type;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setType(TypeElement type) {
        this.type = type;
    }

    protected TypeElement type;
    protected Age age;
}
