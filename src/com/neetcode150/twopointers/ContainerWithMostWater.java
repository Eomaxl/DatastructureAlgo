package com.neetcode150.twopointers;
/**
 * You are given an integer array heights where heights[i] represents the height of the i bar. You may choose any two bars to form a container.
 * Return the maximum amount of water a container can store.
 * Example 1 : Input heights = [1,7,2,5,4,7,3,6], Output: 36
 * Example 2 : Input heights = [2,2,2] Output : 4
 *
 * */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = { 1, 7, 2, 5, 4, 7, 3, 6};
        ContainerWithMostWater cw = new ContainerWithMostWater();
        System.out.println(cw.maxArea(heights));
    }

    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        while (left < right){
            int currentArea = (right - left) * Math.min(heights[left], heights[right]);
            if (heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
