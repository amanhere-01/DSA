package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Inbuilt {
    public static void main(String[] args) {

        // Queue is Interface and if we create object of queue then all the methods of queue Interface should be override
        // Queue is basically a type of linked list where deletion is happened where the head node is present(i.e, at the start) and the insertion is happened at the end

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(21);
//        queue.add(41);
//        queue.add(51);
//        queue.add(71);
//        System.out.println(queue.peek());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.peek());


        //  Dequeue
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(21);
        deque.add(51);
        deque.add(31);
        deque.addFirst(99);
        deque.addLast(89);
        System.out.println(deque.peek());
        System.out.println(deque.removeFirst());
        System.out.println(deque.peek());
        deque.remove();
        System.out.println(deque.peek());
        deque.removeLast();
        System.out.println(deque.peek());

    }
}
