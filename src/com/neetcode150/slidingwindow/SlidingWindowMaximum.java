package com.neetcode150.slidingwindow;
/**
 * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array.
 * The window slides one position to the right until it reaches the right edge of the array.
 * Return a list that contains the maximum element in the window at each step.
 * Example 1: nums = [1, 2, 1, 0, 4, 2, 6], k= 3 Output: [2 , 2, 4, 4, 6]
 * */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        SlidingWindowMaximum sw = new SlidingWindowMaximum();
        int[] result = sw.maxSlidingWindow(nums, k);
        for(int num : result){
            System.out.print(num+"|");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = nums[0];
        rightMax[n-1] = nums[n-1];

        for (int i =1; i< n; i++) {
            if ( i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i-1], nums[i]);
            }

            if((n - 1 - i) % k == 0) {
                rightMax[n - 1 - i] = nums[n - 1 -i];
            } else {
                rightMax[n - 1 - i] = Math.max(rightMax[n-i], nums[n-1-i]);
            }
        }
        int[] output = new int[n - k + 1];
        for(int i =0; i < n -k + 1; i++) {
            output[i] = Math.max(leftMax[i + k - 1], rightMax[i]);
        }
        return output;
    }
}
