package com.neetcode150.oneDimensionDP;

import java.util.Arrays;

public class HouseRobber {
    private int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[nums.length-1];
    }

    public int robMemo(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int n) {
        if (n >= nums.length) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = Math.max(dfs(nums, n+1), dfs(nums, n+2)+nums[n]);
        return memo[n];
    }
}
