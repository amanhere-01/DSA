package Queue;

public class Main {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue(5);
//        queue.add(21);
//        queue.add(41);
//        queue.add(51);
//        queue.add(71);
//        queue.add(91);
//        queue.display();
//        System.out.println(queue.remove());
//        queue.display();
//        queue.add(29);
//        queue.display();

//        CircularQueue queue1 = new CircularQueue(5);
//        queue1.add(21);
//        queue1.add(41);
//        queue1.add(51);
//        queue1.add(71);
//        queue1.add(91);
//        queue1.display();
//        System.out.println(queue1.remove());
//        queue1.display();
//        queue1.add(29);
//        queue1.display();

        DynamicQueue queue2 = new DynamicQueue(4);
        queue2.add(21);
        queue2.add(41);
        queue2.add(51);
        queue2.add(71);
        queue2.add(91);
        queue2.display();
        System.out.println(queue2.remove());
        queue2.display();
        queue2.add(29);
        queue2.display();

    }
}
