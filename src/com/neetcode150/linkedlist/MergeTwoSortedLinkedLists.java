package com.neetcode150.linkedlist;

/**
 *
 *   Input: list1 = [1,2,4], list2 = [1,3,5] Output: [1,1,2,3,4,5]
 *   Input: list1 = [], list2 = [] Output: []
 *   Input: list1 = [], list2 = [1,2] Output: [1,2]
 *
 * */

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return dummy.next;
    }
}
