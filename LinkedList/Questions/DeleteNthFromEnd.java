package LinkedList.Questions;

public class DeleteNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode slow= head;
        ListNode fast =head;
        // Make a gap of n b/w slow and fast
        for(int i=0; i<n; i++){
            fast=fast.next;
        }
        if(fast==null){     // this is for the case when n=size of list(i.e the first node)
            return head.next;
        }
        // Now that fast is n step ahead, traverse fast to the last node from here and simultaneously move slow
        // when fast is at last node then the slow will be at node at n-1 node from last
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next= slow.next.next;
        return head;
    }


    // Brute force
    // Finding size of node then traversing to the deleted node-1
     public ListNode removeNthFromEnd2(ListNode head, int n) {
         if (head.next == null) {
             return null;
         }
         int size = 0;
         ListNode temp = head;
         while (temp != null) {
             size++;
             temp = temp.next;
         }
         if (n == size) {
             head = head.next;
         } else {
             ListNode t = head;
             for (int i = 1; i < size - n; i++) {
                 t = t.next;
             }
             t.next = t.next.next;
         }

         return head;
     }
}
