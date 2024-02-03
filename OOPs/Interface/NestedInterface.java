package OOPs.Interface;


class A{
    public interface nestedInterface{
        boolean isOdd(int num);
    }
}

class B implements A.nestedInterface {
    @Override
    public boolean isOdd(int num) {
        return (num &1)==1;
    }
}

public class NestedInterface{
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(34));
    }
}
