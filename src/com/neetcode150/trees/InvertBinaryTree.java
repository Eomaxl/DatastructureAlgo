package com.neetcode150.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 * Example : Input: root = [1,2,3,4,5,6,7], Output: [1,3,2,7,6,5,4]
 * Example 2 : Input: root = [3, 2, 1], Output: [3, 1, 2]
 * Example 3 : Input: root = [], output: []
 * */
public class InvertBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode result = obj.invertTree(root);
    }

    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public TreeNode invertTreeBFS(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x){
        this.val = x;
    }
    TreeNode(int x, TreeNode left, TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
