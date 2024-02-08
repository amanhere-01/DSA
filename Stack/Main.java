package Stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        CustomStack stack = new CustomStack();
        stack.push(21);
        stack.push(31);
        stack.push(41);
        stack.push(51);
        stack.push(61);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
