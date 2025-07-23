package com.neetcode150.heapPriorityQueue;

import java.util.PriorityQueue;

/**
 * Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
 * By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
 * Follow-up: Can you solve it without sorting?
 * Example 1: Inputs nums = [2,3,1,5,4], k = 2 Output: 4
 * Example 2: Inputs nums = [2,3,1,1,5,5,4] , k = 3 Output: 4
 * */

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {   // Time complexity: O(n logK) SC: O(k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num: nums) {
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }


}
