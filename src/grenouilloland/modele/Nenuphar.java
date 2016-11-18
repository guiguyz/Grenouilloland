package grenouilloland.modele;

/**
 *
 */
public class Nenuphar {


    public Nenuphar(){
        this.type=type.EAU;
        this.age=age.Grand;
    };

    public void viellir(){


    }

    public TypeElement getType() {
        return type;
    }

    public void setType(TypeElement type) {
        this.type = type;
    }

    protected TypeElement type;
    protected Age age;
}
