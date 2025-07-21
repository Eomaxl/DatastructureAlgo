package com.neetcode150.trees;

import java.util.*;

/**
 * Given the root of a binary tree, return its depth.
 * The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * */

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {           //TC : O(n) and SC : O(n)
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepthDFS(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }
}
