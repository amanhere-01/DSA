package OOPs.Inheritance;


class AFirst {

    AFirst(){
        System.out.println("I'm AFirst constructor");
    }
    AFirst(int i){
        System.out.println("I'm in overloaded AFirst constructor and Value of i is " + i);
    }
}

class BSecond extends AFirst {

    BSecond(){
        super(21);  // by default AFirst constructor without argument will run but
        // if we use super and give it argument then AFirst constructor with argument wala run hoga
        System.out.println("I'm BSecond constructor ");
    }

    BSecond(int x , int y){
        super(x);   // This super directly goes to AFirst overloaded constructor like in previous one
        System.out.println("I'm overloaded constructor of BSecond and value is "+ y);
    }
}


class CThird extends BSecond {

    CThird(){
        System.out.println("I'm CThird constructor ");
    }

    CThird(int x, int y , int z){
        super(x,y);
        System.out.println("I'm in overloaded constructor of CThird and the value is "+ z);
    }

}
public class ConstructorInheritance {
    public static void main(String[] args) {

         AFirst h = new AFirst();
         BSecond c = new BSecond();
         BSecond c1 = new BSecond(2,5);  // sabse pahle AFirst class ka constructor active hoga then chew ka

         CThird p= new CThird();
        CThird p2= new CThird(11, 25    , 31);
    }

}

