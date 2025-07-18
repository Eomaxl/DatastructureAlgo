package com.neetcode150.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 * The test cases are generated such that the answer is always unique.
 * You may return the output in any order.
 * Example 1: Input nums =[1,2,2,3,3,3] , k=2 Output: [2,3]
 * Example 2: Input nums = [7,7] , k =1, Output: [7]
 *
 * */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3,3,3};
        int k1 = 2, k2 = 1;
        int[] arr2 = {7,7};
        int[] result1 = topKFrequent(arr1, k1);
        int[] result2 = topKFrequent(arr2, k2);
        System.out.println("Top k frequent elements in array");
        for(int n: result1){
            System.out.print(n + " ");
        }
        System.out.println("\nTop k frequent elements in array");
        for(int n: result2){
            System.out.print(n + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }

        Map<Integer,Integer> count = new HashMap<>();
        for(int n: nums){
            count.put(n, count.getOrDefault(n,0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
                (a,b) -> count.get(a)-count.get(b)
        );

        for(int n: count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i =0 ; i<k; i++){
            ans[i] = heap.poll();
        }

        return ans;
    }

}
