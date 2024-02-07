// https://leetcode.com/problems/linked-list-cycle/description/


package LinkedList.Questions;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class CycleLL {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    // To find length of cycle
    public int lengthCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast ==slow){        // when slow= fast then stop the slow(or fast) there and traverse the temp from there until it meets the slow(or fast) again
                int length =0;
                ListNode temp= slow;
                do{                     // At start temp is equal to slow so we have to run this loop once
                    temp= temp.next;
                    length++;
                }
                while (temp != slow);

                return length;
            }
        }
        return 0;
    }

}
