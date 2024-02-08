package Stack;

import java.util.Stack;

public class Inbuilt {
    public static void main(String[] args) {

        Stack<Integer> stack= new Stack<>();
        stack.push(21);
        stack.push(31);
        stack.push(41);
        stack.push(51);
        stack.push(61);
        System.out.println(stack.pop());    // By default pop function returns int value which is going to be deleted
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
