package com.neetcode150.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0,
 * and the indices i, j and k are all distinct.
 * The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
 * Example 1 : Input nums:[-1,0,1,2,-1,-4] , output: [[-1,-1,2],[-1,0,1]]
 *
 * */

public class ThreeIntegerSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeIntegerSum obj = new ThreeIntegerSum();
        List<List<Integer>> result = obj.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0)break;
            if( i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i+1, r = nums.length-1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                } else if(sum < 0){
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while ( l < r && nums[l] == nums[l+1]) l++;
                }
            }
        }
        return  res;
    }
}
