//  https://leetcode.com/problems/implement-queue-using-stacks/

package Stack.Question;

import java.util.Stack;

public class QueueUsingStack {

    class MyQueue {
        Stack<Integer> first;
        Stack<Integer> second;
        public MyQueue() {
            first=new Stack<>();
            second = new Stack<>();
        }

        // for adding transfer elements to second stack then push the given number then again transfer the second stack to first stack
        public void push(int x) {
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            first.push(x);
            while(!second.isEmpty()){
                first.push(second.pop());
            }
        }

        public int pop() {
            return first.pop();
        }

        public int peek() {
            return first.peek();
        }

        public boolean empty() {
            return first.isEmpty();
        }
    }
}
