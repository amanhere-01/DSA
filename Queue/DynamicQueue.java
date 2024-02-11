package Queue;

public class DynamicQueue extends  CircularQueue{
    public DynamicQueue() {
        super();    // it will call CustomStack()
    }

    public DynamicQueue(int size) {
        super(size);    // it will call CustomStack(size)
    }

    @Override
    public void add(int val) throws Exception {
        if(this.isFull()){
            int[] temp = new int[data.length * 2];
            // copy prev items in new stack
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[ (front+i) % data.length];
            }
            front=0;
            end= data.length;
            data= temp;
        }
        super.add(val);
    }
}
