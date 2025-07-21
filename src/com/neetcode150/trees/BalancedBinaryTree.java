package com.neetcode150.trees;
import java.util.*;
/**
 * Given a binary tree, return true if it is height-balanced and false otherwise.
 * A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * Example : Input: root = [1,2,3,null,null,4] , Output: true
 *
 * */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> depths = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, last = null;

        while (!stack.isEmpty() || node != null) {
            if (node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if( node.right == null || last == node.right) {
                    stack.pop();
                    int left = depths.getOrDefault(node.left, 0);
                    int right = depths.getOrDefault(node.right, 0);
                    if (Math.abs(left - right) > 1) return false;
                    depths.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node =  node.right;
                }
            }
        }
        return true;
    }
}
