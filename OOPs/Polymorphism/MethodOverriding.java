package OOPs.Polymorphism;

// Static methods can be inherited but can not be overridden bc Overriding depends on objects, static does not depends on object hence static methods can not be overridden
class A{

    static void show(){
        System.out.println("Static method here");
    }
    public void meth1(){
        System.out.println("I'm method 1 of class A");
    }

    final public void meth2(){                          // When we use final keyword then we can't override this method.Likewise, if we make a class final then we can't inherit it
        System.out.println("I'm method 2 of class A");
    }
}

class B extends A{


//    @Override
//    static void show(){
//        System.out.println("Class b static method");
//    }
//

    @Override // this is not compulsory but recommended, it indicates method overriding
    public void meth1(){
        System.out.println("I'm method 1 of class B ");
    }

}

public class MethodOverriding {
    public static void main(String[] args) {

        B b= new B();
        b.meth1();

        A ab = new B();     // here reference type is of class A and object type is of class B. However it will call meth1 of class B unlike in normal condition when we do this type of shit then methods of class A is called
        ab.meth1();

        A.show();
        B.show();   // we can inherit 

    }
}
