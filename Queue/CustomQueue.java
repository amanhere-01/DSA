package Queue;

public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE=10;

    private int end = 0;   // Inserting from end
    public CustomQueue(){
        this(DEFAULT_SIZE);         // this will call constructor with size argument
    }
    public CustomQueue(int size){
        this.data= new int[size];
    }

    public void add(int val) throws Exception{       //O(1) Time Complexity
        if(isFull()){
            throw new Exception("Queue is full");
        }
        data[end++] = val;
    }

    public int remove() throws Exception{   // removing from start and it takes O(n) time
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int deleted= data[0];
        //shifting elements
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;

        return deleted;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty(){
        return end == 0;
    }
}
