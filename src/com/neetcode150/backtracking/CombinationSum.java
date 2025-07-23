package com.neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Example 1 : Input: nums = [2,5,6,9] target = 9 Output: [[2,2,5],[9]]
 * Example 2 : Input: nums = [3,4,5] target = 16 Output:  [[3,3,3,3,4],[3,3,5,5],[4,4,4,4],[3,4,4,5]]
 * */
public class CombinationSum {
    List<List<Integer>> res;
    public static void main(String[] args) {
        int[] nums = {2,5,6,9};
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(nums, 9);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i + 1);
    }

}
