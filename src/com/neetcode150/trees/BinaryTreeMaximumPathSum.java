package com.neetcode150.trees;

/**
 * Given the root of a non-empty binary tree, return the maximum path sum of any non-empty path.
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes has an edge connecting them. A node can not appear in the sequence more than once. The path does not necessarily need to include the root.
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Example 1: input root = [1,2,3] , Output: 6
 * Example 2: input root = [-15,10,20,null,null,15,5,-5], Output: 40
 * */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[] {root.val};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(dfs(root.left, res),0);
        int rightMax = Math.max(dfs(root.right, res), 0);

        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
