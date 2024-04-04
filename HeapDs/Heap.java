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
        if(list.get(index).compareTo(list.get(parentIndex)) < 0){       // if parent is greater than child then swap
            swap(index,parentIndex);
            upheap(parentIndex);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("List is Empty");
        }
        T removed= list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){    // if list has one element then on removing list would be empty
            list.set(0,last);
            downheap(0);
        }
        return  removed;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = left(index);

        if (left<list.size() && list.get(min).compareTo(list.get(left)) > 0){   // if element at min> element at left
            min= left;
        }
        if(right<list.size() && list.get(min).compareTo(list.get(right))>0){
            min= right;
        }

        if(min != index){   // if min has changed then only this will be called
            swap(min, index);
            downheap(min);
        }

    }


}
