package com.neetcode150.trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.
 * A bonary search tree satisfies the following constraints:
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 *
 * */
public class KthSmallestElementInaBST {
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> res){
        if(root == null) return res;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
        return res;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }

    public int IterativeDFSS(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if(k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

}
