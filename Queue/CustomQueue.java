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

    
    public boolean isFull() {
        return end == data.length;
    }

    private boolean isEmpty(){
        return end == 0;
    }
}
