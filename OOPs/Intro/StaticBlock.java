package OOPs.Intro;

public class StaticBlock {

    static int a =4;
    static  int b;


    static {    // Will only run once when the first object is created i.e, when the class is loaded for the first time
        System.out.println("Static block running");
        b = a*5;
    }

    public static void main(String[] args) {
        StaticBlock sb = new StaticBlock(); // when this object is created then only this line will run 'System.out.println("Static block running");'. If we create object again then it will run not run again.
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
        StaticBlock obj = new StaticBlock();    // This will not be able to run System.out.println("Static block running");
        StaticBlock.b += 5;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);
    }
}
