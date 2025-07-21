package com.neetcode150.trees;

import java.util.*;
/**
 * The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree.
 * The path does not necessarily have to pass through the root.
 * The length of a path between two nodes in a binary tree is the number of edges between the nodes.
 * Given the root of a binary tree root, return the diameter of the tree.
 * Example 1: Input: root = [1,null,2,3,4,5] output: 3
 * Example 2: Input : root = [1,2,3] output: 2
 * */
public class DiameterBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, int[]> mp = new HashMap<>();
        mp.put(null, new int[]{0,0});
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !mp.containsKey(node.left)){
                stack.push(node.left);
            } else if (node.right != null && !mp.containsKey(node.right)){
                stack.push(node.right);
            } else {
                node = stack.pop();

                int[] leftData = mp.get(node.left);
                int[] rightData = mp.get(node.right);

                int leftHeight = leftData[0], leftDiameter = leftData[1];
                int rightHeight = rightData[0], rightDiameter = rightData[1];

                int height = 1 + Math.max(leftHeight, rightHeight);
                int diameter = Math.max(leftHeight + rightHeight,
                        Math.max(leftDiameter, rightDiameter));

                mp.put(node, new int[]{height, diameter});
            }
        }
        return mp.get(root)[1];
    }
}
