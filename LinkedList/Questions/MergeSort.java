package LinkedList.Questions;



public class MergeSort {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast= head;
        ListNode slow=head;
        ListNode temp=head;
        while(fast!=null && fast.next!= null){
            temp=slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        // head is start of first half and temp is tail of first half
        // slow is head of second half and fast is tail of second half
        // Temp node is previous to the slow node
        temp.next= null;    // temp.next=null ensures that the list is split into two halves
        ListNode left= sortList(head);
        ListNode right= sortList(slow);

        return merge(left,right);
    }


    public ListNode merge(ListNode list1 , ListNode list2){
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }
        if(list1 != null){
            tail.next=list1;
        }
        if(list2 != null){
            tail.next = list2;
        }

        return head.next;
    }
}
