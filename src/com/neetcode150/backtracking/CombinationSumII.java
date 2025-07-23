package com.neetcode150.backtracking;
import java.util.*;

/**
 * Input: candidates = [9,2,2,4,6,1,5], target = 8, Output: [[1,2,5],[2,2,4],[2,6]]
 *
 * */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = {9,2,2,4,6,1,5};
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> result = combinationSumII.combinationSum2(nums, 8);
        for (List<Integer> list : result) {
            System.out.print(list+" | ");
        }
    }

    private static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private static void dfs(int idx, List<Integer> path, int cur, int[] candidates, int target) {
        if (cur == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (cur + candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            dfs(i + 1, path, cur + candidates[i], candidates, target);
            path.remove(path.size() - 1);
        }
    }
}
