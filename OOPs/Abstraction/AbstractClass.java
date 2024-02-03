package OOPs.Abstraction;

import javax.crypto.spec.PSource;


abstract class PC {
    int ram;

    // We can also create constructor in abstract class, but we can not create abstract constructor and abstract static method
    public PC(int ram) {
        this.ram=ram;
    }

    //we can create static and normal methods too
    static void show() {
        System.out.println("This is static class");
    }

    public void Parent2() {
        System.out.println("Coefierce");
    }

    // when we declare any method abstract then we also have to declare the class abstract
    abstract public void greet();

    abstract public void battery();

}

class MSI extends PC{

    public MSI(int ram) {
        super(ram);
    }

    // We have to override all the methods of above abstract class
    @Override
    public void greet(){
        System.out.println("Welcome to MSI world");
    }

    @Override
    public void battery(){
        System.out.println("Your battery is 21%");
    }

    void poweroff(){
        System.out.println("Powering off your phone");     // we can also add our own method in this class along-with abstract methods
    }
}


public class AbstractClass {
    public static void main(String[] args) {

        //PC p  = new PC();   // We can not create object of Abstract class.PC is abstract class so this is not allowed
        MSI m = new MSI(8);  // MSI is concrete class so this is allowed
        PC p1 = new MSI(8);        // --> This is dynamic method dispatch
        m.greet();
        m.battery();
        m.poweroff();
        PC.show();
    }
}
