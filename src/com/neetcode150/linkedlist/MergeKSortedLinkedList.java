package com.neetcode150.linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        for (ListNode node : lists) {
            while (node != null) {
                minHeap.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode mergedNode = dummy;
        while (!minHeap.isEmpty()){
            mergedNode.next = new ListNode(minHeap.remove());
            mergedNode = mergedNode.next;
        }
        return dummy.next;
    }
}
