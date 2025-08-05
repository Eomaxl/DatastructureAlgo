package com.neetcode150.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        for(int i : nums){
            if (set.contains(i)){
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        // initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[nums[0]];

        // find the intersection point of two runners
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // find the entrance to the cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
