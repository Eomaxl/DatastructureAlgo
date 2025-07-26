package com.neetcode150.greedy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = 0;

        for(int i =0; i <nums.length; i++){
            if(currentSum < 0){
                currentSum = 0;
            }
            currentSum +=  nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];

        dp[n- 1][1] = dp[n-1][0] = nums[ n - 1];

        for (int i = n - 2; i>= 0; i--) {
            dp[i][1] = Math.max(nums[i], nums[i]+dp[i+1][1]);

            dp[i][0] = Math.max(dp[i+1][0], dp[i][1]);
        }

        return dp[0][0];
    }
}
