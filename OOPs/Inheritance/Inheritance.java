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

}

class Derived extends Base {     // here in derived class we can get property of base class also
    int y;

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

        Base b = new Base();
        b.setX(21);
        System.out.println(b.getX());

        // we can also do this by creating an object of derived class
        Derived d = new Derived();

        d.setX(41);
        System.out.println(d.getX());

        d.setY(234);
        System.out.println(d.getY());
    }
}
