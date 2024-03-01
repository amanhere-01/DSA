package SetsAndMaps;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AllSets {
    public static void main(String[] args) {

        // HashSet store element unordered

        HashSet<Integer> h= new HashSet<>(5,0.5f);
        h.add(23);
        h.add(87);
        h.add(98);
        h.add(6);
        h.add(54);
        h.add(54); // 54 will be printed only one time
        h.remove(98);
        System.out.println(h.contains(6));
        System.out.println(h.size());

        System.out.println(h);

        //  LinkedHashSet store in order(in same way in which it is added)

        LinkedHashSet<Integer> lhs= new LinkedHashSet<>();
        lhs.add(23);
        lhs.add(87);
        lhs.add(98);
        lhs.add(6);
        lhs.add(54);
        System.out.println(lhs.contains(6));
        System.out.println(lhs.size());

        System.out.println(lhs);


        // TreeSet stores in sorted way
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(21);
        ts.add(34);
        ts.add(66);
        ts.add(43);
        ts.add(1);
        System.out.println(ts);
    }
}
