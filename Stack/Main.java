package Stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
//        CustomStack stack = new CustomStack(5);
        CustomStack stack = new DynamicStack(5);
        stack.push(21);
        stack.push(31);
        stack.push(41);
        stack.push(51);
        stack.push(61);
        stack.push(88);
        stack.push(99);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
