package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of unique integers, return all possible subsets of nums.
 * The solution set must not contain duplicate subsets. You may return the solution in any order.
 * Example 1: Inputs nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        for (List<Integer> list : result) {
            System.out.print(list+" | ");
        }
    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        if ( index >= nums.length ) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, result);
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, result);
    }

}
