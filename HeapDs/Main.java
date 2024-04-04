package HeapDs;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(54);
        heap.insert(87);
        heap.insert(43);
        heap.insert(21);
        heap.insert(11);
        heap.insert(89);

        System.out.println(heap.remove());

        ArrayList<Integer> list = heap.heapSort();
        System.out.println(list);
    }
}
