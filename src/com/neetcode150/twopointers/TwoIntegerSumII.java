package com.neetcode150.twopointers;

/**
 * Given an array of integers numbers that is sorted in non-decreasing order. Return the indices (1-indexed) of two numbers, [index1, index2],
 * such that they add up to a given target number target and index1 < index2.
 * Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
 * There will always be exactly one valid solution.
 * Your solution must use O(1) additional space.
 * Example 1: numbers = [1,2,3,4], Target = 3 , Output  = [1,2]
 * Example 2:
 * */
public class TwoIntegerSumII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 6;
        TwoIntegerSumII twoIntegerSumII = new TwoIntegerSumII();
        int[] result = twoIntegerSumII.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[]{low+1, high+1};
            } else if ( sum < target){
                low++;
            } else if ( sum > target){
                high--;
            }
        }
        return new int[]{};
    }
}
