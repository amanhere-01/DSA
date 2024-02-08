package Stack;

public class DynamicStack extends CustomStack{
    public DynamicStack() {
        super();    // it will call CustomStack()
    }

    public DynamicStack(int size) {
        super(size);    // it will call CustomStack(size)
    }

    @Override
    public void push(int val) throws Exception {
        if(this.isFull()){
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data= temp;
        }
        super.push(val);
    }
}
