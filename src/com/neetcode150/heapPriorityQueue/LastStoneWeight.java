package com.neetcode150.heapPriorityQueue;

import java.util.PriorityQueue;

/**
 * You are given an array of integers stones where stones[i] represents the weight of the ith stone.
 * We want to run a simulation on the stones as follows:
 * At each step we choose the two heaviest stones, with weight x and y and smash them togethers
 * If x == y, both stones are destroyed
 * If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * Continue the simulation until there is no more than one stone remaining.
 * Return the weight of the last remaining stone or return 0 if none remain.
 * Example 1:  Input: stones = [2,3,6,2,4], Output: 1
 * Explanation:
 * We smash 6 and 4 and are left with a 2, so the array becomes [2,3,2,2].
 * We smash 3 and 2 and are left with a 1, so the array becomes [1,2,2].
 * We smash 2 and 2, so the array becomes [1].
 * */

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 3, 2, 2};
        int[] stones2 = {1, 2, 2};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
        System.out.println(lastStoneWeight.lastStoneWeight(stones2));
        System.out.println(lastStoneWeight.lastStoneWeightMaxHeap(stones));
        System.out.println(lastStoneWeight.lastStoneWeightMaxHeap(stones2));
    }

    public int lastStoneWeightMaxHeap(int[] stones){
        // create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Continuously remove and smash the two heaviest stones
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // The heaviest stone
            int x = maxHeap.poll(); // The second heaviest stone

            if (x != y){
                maxHeap.add(x);     // Add the remaining stone back to the heap
            }
        }
        // Return the weight of the last remaining stone or 0 if no stones are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s: stones){
            minHeap.add(-s);
        }

        while (minHeap.size() > 1){
            int first = minHeap.poll();
            int second = minHeap.poll();
            if(second > first) {
                minHeap.offer(first - second);
            }
        }

        minHeap.offer(0);
        return Math.abs(minHeap.peek());

    }
}


// Time Complexity : O(n log n) and space complexity : O(n)