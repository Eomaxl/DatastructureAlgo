package com.neetcode150.linkedlist;

/**
 *
 *
 * Input : head = [0,1,2,3], Output: [3,2,1,0]
 *
 * */

class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
       ListNode prev = null;
       ListNode curr = head;

       while (curr != null){
           ListNode temp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;
       }
       return prev;
    }
}
