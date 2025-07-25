package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> ans = subsetsII.subsetsWithDup(nums);
        for(List<Integer> l : ans){
            System.out.print(l+" | ");
        }
    }
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums) {
        res.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            backtrack(j + 1, subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
