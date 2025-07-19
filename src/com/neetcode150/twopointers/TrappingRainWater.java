package com.neetcode150.twopointers;

/**
 * You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
 * Return the maximum area of water that can be trapped between the bars.
 * Example 1 : Input heights = [0, 2, 0, 3, 1, 0, 1, 3, 2, 1] Output : 9
 *
 * */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(heights));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }

        int l = 0, r = height.length - 1;

        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if(leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}


//Time complexity: O(n) Space complexity: O(1)