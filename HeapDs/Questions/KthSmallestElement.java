//  https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

package HeapDs.Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = { 7 ,10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr, 3));
    }

    public static int kthSmallest(int[] arr, int k)
    {
        Comparator<Integer> maxHeapComparator = Comparator.reverseOrder();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxHeapComparator);

        for(int num: arr){
            maxHeap.offer(num);
            if (maxHeap.size()> k){
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
