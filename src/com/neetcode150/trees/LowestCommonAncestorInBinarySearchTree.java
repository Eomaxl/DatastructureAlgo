package com.neetcode150.trees;

/**
 * Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q,
 * return the lowest common ancestor (LCA) of the two nodes.
 * The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants.
 * The ancestor is allowed to be a descendant of itself.
 * Example 1: Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 8, Output: 5
 * Example 2: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 4 , Output : 3
 *
 * */
public class LowestCommonAncestorInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.right = new TreeNode(2);
        LowestCommonAncestorInBinarySearchTree obj = new LowestCommonAncestorInBinarySearchTree();
        TreeNode result = obj.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(result.val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }
}
