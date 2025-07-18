package com.neetcode150.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 * Return the answer with the smaller index first.
 * Example 1: Input: nums = [3,4,5,6], target = 7 Output: [0,1]
 * Example 2: Input: nums = [4,5,6], target = 10 Output: [0,2]
 * Example 3: Input: nums = [5,5] target = 10 Output: [0,1]
 * */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mapping = new HashMap<>();
        int idx =0;
        for(int num: nums){
            if(!mapping.containsKey(target-num)){
                mapping.put(num,idx);
                idx++;
            } else {
                return new int[]{mapping.get(target-num),idx};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] result =ts.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0]+"|"+result[1]);
    }
}


// TC: O(n), SC: O(n)