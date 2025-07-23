package com.neetcode150.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.
 * A valid binary search tree satisfies the following constraints:
 *  The left subtree of every node contains only nodes with keys less than the node's key.
 *  The right subtree of every node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees are also binary search trees.
 *
 *  Example 1: Input root = [2,1,3] Output: true
 *  Example 2: Input root = [1,2,3] Output: false
 * */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        System.out.println("is it a valid binary search tree :"+obj.isValidBSTBFS(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("is it a valid binary search tree :"+obj.isValidBSTDFS(root));
    }

    public boolean isValidBSTDFS(TreeNode root) {
        return valid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean valid(TreeNode root, long left, long right) {
        if(root == null) return true;
        if(!(left < root.val && root.val < right)){
            return false;
        }
        return valid(root.left, left, root.val) && valid(root.right,root.val,right);
    }

    public boolean isValidBSTBFS(TreeNode root){
        if(root == null) {
            return true;
        }

        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[] {root, Long.MIN_VALUE, Long.MAX_VALUE});

        while (!queue.isEmpty()){
            Object[] obj = queue.poll();
            TreeNode node = (TreeNode) obj[0];
            long left = (long) obj[1];
            long right = (long) obj[2];


            if (!(left < node.val && node.val < right)) {
                return false;
            }

            if (node.left != null) {
                queue.offer(new Object[]{node.left, left, (long) node.val});
            }
            if (node.right != null) {
                queue.offer(new Object[]{node.right, (long) node.val, right});
            }
        }
        return true;
    }
}
