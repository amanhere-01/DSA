package OOPs;

public class Constructors {
    public static void main(String[] args) {

        Any a = new Any(23, "deploy");
        Any c = new Any();
        Any b = new Any(a);     // passing object as argument
//        System.out.println(a.id + " " + a.name);
        System.out.println(a.id + " " + a.name);
        System.out.println(b.id + " " + b.name);
        System.out.println(c.id + " " + c.name);
    }

}

class Any {
        int id;
        String name;
        Any(){
            // We can also call constructor from another constructor
            this(302, "josh");


        }

        Any(int id, String naam){
            this.id = id;       // Here argument have same name of id so If we write id=id then machine would get confuse that's why we use 'this' keyword
            this.name=  naam;        // here name and naam are different so we assign like name= naam it will be okay but it is not good practice so use this keyword

        }

        // passing other object of same class to the argument in constructor
        Any( Any extra){        // here values will be assigned whatever values 'extra' object has
            this.id= extra.id;
            this.name = extra.name;
        }
}

