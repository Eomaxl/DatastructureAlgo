package com.neetcode150.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
 * The elements do not have to be consecutive in the original array.
 * You must write an algorithm that runs in O(n) time.
 * Example 1: Input nums = [2,20,4,10,3,4,5], Output: 4
 * Example 2: Input nums = [0,3,2,5,4,6,1,1], Output: 7
 * */

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] arr1 = {2,20,4,10,3,4,5};
        int[] arr2 = {0,3,2,5,4,6,1,1};
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(arr1));
        System.out.println(lcs.longestConsecutive(arr2));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num : nums){
            num_set.add(num);
        }

        int longestStreak = 0;

        for(int num : num_set){
            if(!num_set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                while(num_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
