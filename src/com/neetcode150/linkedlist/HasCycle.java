package com.neetcode150.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<Integer> nodeCol = new HashSet<>();
        ListNode curr = head;

        while (curr != null){
            if (!nodeCol.contains(curr.val)){
                nodeCol.add(curr.val);
            } else {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean fastSlowPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){ return true;}
        }
        return false;
    }
}
