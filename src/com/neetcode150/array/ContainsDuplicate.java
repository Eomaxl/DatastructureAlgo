package com.neetcode150.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
 * Example 1: Input: nums = [1, 2, 3, 3]
 * Output: true
 *
 *
 * Example 2: Input nums = [1,2,3,4]
 * Output: false
 * */

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int num: nums){
            if(numbers.contains(num)){
                return true;
            }
            numbers.add(num);
        }
        return false;
    }
    public static void main(String[] args){
        int[] num1 = {1,2,3,3};
        int[] num2 = {1,2,3,4};
        System.out.println("Does array num1 has duplicate ? "+containsDuplicate(num1));
        System.out.println("Does array num2 has duplicate ? "+containsDuplicate(num2));
    }
}


/// Time complexity is O(n) , Space Complexity is O(n)
// Alternative approach is sorting - TC O(nlogn), Space Complexity - O(1)