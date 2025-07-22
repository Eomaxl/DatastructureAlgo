package com.neetcode150.trees;

/**
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 * Example 1: Input: root = [1,2,3,4,5], subRoot = [2,4,5] Output: true
 * Example 2: Input: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5] Output: false
 *
 * */

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode subroot = new TreeNode(2);
        subroot.left = new TreeNode(4);
        subroot.right = new TreeNode(5);
        SubtreeOfAnotherTree subtree = new SubtreeOfAnotherTree();
        System.out.println(subtree.isSubtree(root, subroot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if(sameTree(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if (root != null && subRoot != null && root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        }
        return false;
    }
}
