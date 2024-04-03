package HeapDs;

import java.util.ArrayList;

public class Heap <T extends Comparable<T> > {
    private ArrayList<T> list;

    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public int parent(int index){
        return (index-1)/2;     // Since we are marking root from 0
    }
    public int left(int index){
        return 2*index + 1;
    }
    public int right(int index){
        return 2*index + 2;
    }

    public void insert(T value){
        list.add(value);
        upheap(list.size() -1 );
    }

    private void upheap(int index) {
        if(index==0){
            return;
        }
        int parentIndex = parent(index);
        if(l)
    }


}
