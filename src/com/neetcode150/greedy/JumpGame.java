package com.neetcode150.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int idx = nums.length - 1;

        for (int i = nums.length -2 ; i>=0 ; i--) {
            if( i + nums[i] >= idx) {
                idx = i;
            }
        }

        return idx == 0;
    }
}
