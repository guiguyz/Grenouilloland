package grenouilloland.modele;

/**
 * Nenuphar.
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public class Nenuphar {


    public Nenuphar(TypeElement type){
        this.type=type;
        this.age=age.GRAND;
    }

    /**
     * Constructeur par defaut
     * Surcharge de constructeur
     * definnisant un nenuphar de base
     * comme étant de l'eau
     * et comme etant toujours grand.
     */
    public Nenuphar(){//
        this.type=type.EAU;
        this.age=age.GRAND;
    };




    public void vieillir(){
            if(getAge()==age.GRAND){
                setAge(age.MOYEN);
            }
            else if(getAge()==age.MOYEN){
                setAge(age=age.PETIT);
            }else{
                setType(type.EAU);
            }
    }




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
