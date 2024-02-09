package LinkedList.SinglyLL;


public class Mergesort {
    public LL.Node sortList(LL.Node head) {
        if(head==null || head.next==null){
            return head;
        }
        LL.Node fast= head;
        LL.Node slow=head;
        LL.Node temp=head;
        while(fast!=null && fast.next!= null){
            temp=slow;
            slow= slow.next;
            fast= fast.next.next;
        }
        // head is start of first half and temp is tail of first half
        // slow is head of second half and fast is tail of second half
        // Temp node is previous to the slow node
        temp.next= null;    // temp.next=null ensures that the list is split into two halves
        LL.Node left= sortList(head);
        LL.Node right= sortList(slow);

        return merge(left,right);
    }


    public LL.Node merge(LL.Node list1 , LL.Node list2){
        LL.Node head = new LL.Node();
        LL.Node tail = head;

        while (list1 != null && list2 != null) {
            if (list1.value > list2.value) {
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
            list1 = list1.next;
        }
        if(list2 != null){
            tail.next = list2;
            list2 = list2.next;
        }

        return head.next;
    }
}
