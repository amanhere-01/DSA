package Queue;

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE=10;

    protected int end = 0;      // Inserting from end
    protected int front=0;      // Deleting from front
    protected int size=0;

    public CircularQueue(){
        this(DEFAULT_SIZE);         // this will call constructor with size argument
    }

    public CircularQueue(int size){
        this.data= new int[size];
    }

    public void add(int value) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }
        data[end]=value;
        end++;
        end= end% data.length;
        size++;
    }

    public int remove() throws Exception{       // This will take O(1) TC unlike custom queue/normal queue
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int deleted = data[front];
        front++;
        front= front% data.length;
        size--;
        return deleted;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int i=front;
        do{
            System.out.print(data[i]+ " ");
            i++;
            i=i% data.length;
        } while (i!=end);
        System.out.println();
    }

    public boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }
}
