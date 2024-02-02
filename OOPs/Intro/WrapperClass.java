package OOPs.Intro;

public class WrapperClass {
    public static void main(String[] args) {

//        Integer a = new Integer(45);    // this method is deprecated now so we use below wala code
        Integer a = 45;
        Integer b= 25;
        swap(a,b);  // Tho above a and b are kind of object but still it won't get swapped
        System.out.println("Outside swap " + a + " " + b);

//       use of final keyword
        final int num = 90;
        // num = 100;      // num is final ,so we can't modify it. When a primitive is final  we can ot reassign it


        final Any any = new Any("Lame");
        any.name= "different";      // here we can modify the class instances tho the object is final
//        any = new Any("again");              // but we can't instantiate the new object to final object

        Any obj = new Any("rancho");
        for (int i = 0; i < 1000000000; i++) {  // this will print message before garbage collection
            obj = new Any("Random name");
        }


    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        System.out.print("Inside swap ");
        System.out.println(a + " " + b);
    }
}

class Any {
    final int num = 10;
    String name;

    public Any(String name) {
//        System.out.println("object created");
        this.name = name;
    }

    // Destroying or freeing of object is called garbage collection and it is done automatically in java. In c++ we used to call Destructor
    // But we can print any message before java start garbage collection but it is now deprecated
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}
