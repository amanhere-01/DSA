import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {

        HashSet<Integer> h= new HashSet<>(5,0.5f);
        h.add(23);
        h.add(87);
        h.add(98);
        h.add(6);
        h.add(54);
        h.add(54); // 54 will be printed only one time

        System.out.println(h);
    }
}
