//  https://leetcode.com/problems/reverse-linked-list/

package LinkedList.Questions;

import LinkedList.SinglyLL.LL;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        

    }


//  This is also recursion method
//  Copied from SinglyLL.LL.reverse()

//    public void reverse(LL.Node node){
//        //  Here first reaching till the tail then reversing after recursion calls get out
//        if(node==tail){
//            head=tail;
//            return;
//        }
//
//        reverse(node.next);     // When node.next= tail then above function calls and return then at that time node is previous of tail
//        tail.next= node;
//        tail=node;
//        tail.next=null;
//
//    }




//  My method

//    public ListNode reverseList(ListNode head) {
//        ListNode prev = head;
//        ListNode tail = head;
//        if(head==null || head.next == null){
//            return head;
//        }else{
//            tail = head.next;
//        }
//        return rev(head, prev, tail);
//    }
//
//    ListNode rev(ListNode head, ListNode prev, ListNode tail){
//        if(tail == null){
//            return head;
//        }
//        prev.next = tail.next;
//        tail.next=head;
//        head=tail;
//
//        return rev(head, prev, prev.next);
//    }
}
