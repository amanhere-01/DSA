package OOPs.Intro;

public class InnerClass {

    static  class Test {
        static int id;
        int age;
        Test(int id , int age ){
            Test.id= id;    // we use static variable with their class name. We can also use this keyword but it is not good practice
            this.age= age;
        }
    }

    public static void main(String[] args) {
        Test a = new Test(21, 36);
        System.out.println(Test.id);
        System.out.println(a.id);   // this is showing soft error that we should access static members via their class name as static member does not require object and 'a' is object
        System.out.println(a.age);
    }
}
