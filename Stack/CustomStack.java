package Stack;

import java.util.concurrent.ExecutionException;

public class CustomStack {
    private int[] data;
    private static final int DEFAULT_SIZE=10;

    private int top = -1;
    public CustomStack(){
        this(DEFAULT_SIZE);     // this will call constructor with size argument
    }
    public CustomStack(int size){
        this.data= new int[size];
    }

    public void push(int val) throws Exception {
        if (isFull()){
            throw new Exception("Stack Overflow");
        }
        top++;
        data[top]=val;
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }
        return data[top--];
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }
        return data[top];
    }
    private boolean isFull() {
        return top == data.length-1;
    }

    private boolean isEmpty(){
        return top == -1;
    }
}
