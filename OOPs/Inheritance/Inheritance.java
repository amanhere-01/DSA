package OOPs.Inheritance;


class Base {
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        System.out.println("I'm in base class and setting x");
        this.x = x;
    }
    void print(){
        System.out.println("In parent class");
    }
}

class Derived extends Base {     // here in derived class we can get property of base class also
    int y;

    void show(){
        System.out.println("In child class");
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        System.out.println("I'm in Derived and setting value of y");
        this.y = y;
    }
}

public class Inheritance {
    public static void main(String[] args) {

        Base b = new Base();    // b is reference variable
        b.setX(21);
        System.out.println(b.getX());

        // we can also do this by creating an object of derived class
        Derived d = new Derived();
        d.setX(41);
        System.out.println(d.getX());
        d.setY(234);
        System.out.println(d.getY());

        // base is reference variable and Derived() is Object created of Derived class
        Base base = new Derived();  // here we can access only members of Base class only, doesn't matter if the object is created of Derived
        base.print();
//        base.show()  ;       // Invalid command

//        Derived derived = new Base();   // Also we can't have child reference variable and parent object

    }
}
