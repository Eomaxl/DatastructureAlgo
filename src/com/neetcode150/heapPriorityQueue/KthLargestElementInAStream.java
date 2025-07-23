package com.neetcode150.heapPriorityQueue;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest integer in a stream of values, including duplicates.
 * E.g. the 2nd largest from [1, 2, 3, 3] is 3. The stream is not necessarily sorted.
 * Implement the following methods:
 * constructor(int k, int[] nums) Initializes the object given an integer k and the stream of integers nums
 * int add(int val) Adds the integer val to the stream and returns the kth largest integer in the stream.
 *
 * Input:
 * ["KthLargest", [3, [1, 2, 3, 3]], "add", [3], "add", [5], "add", [6], "add", [7], "add", [8]]
 * Output: [null, 3, 3, 3, 5, 6]
 *
 *
 * */
public class KthLargestElementInAStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}


// TC : O(m * logK) where m is the number of calls made to add()
// SC : O(k)