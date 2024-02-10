package Queue;

public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    private int end = 0;   // Inserting from end
    public CustomQueue(){
        this(DEFAULT_SIZE);         // this will call constructor with size argument
    }
    public CustomQueue(int size){
        this.data= new int[size];
    }

    public void insert(int val) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }
        data[end++] = val;
    }

    public int remove() throws Exception{   // removing from start
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


    public boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty(){
        return end == 0;
    }
}
