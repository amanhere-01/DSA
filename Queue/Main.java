package Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();
        queue.add(21);
        queue.add(41);
        queue.add(51);
        queue.add(71);
        queue.add(91);
        queue.display();
        queue.remove();
        queue.display();
    }
}
