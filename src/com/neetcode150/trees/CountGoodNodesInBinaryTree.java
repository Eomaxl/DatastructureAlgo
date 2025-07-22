package com.neetcode150.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Within a binary tree, a node x is considered good if the path from the root of the tree to the node x
 * contains no nodes with a value greater than the value of node x
 * Given the root of a binary tree root, return the number of good nodes within the tree.
 * Example 1 : Input root = [2, 1, 1, 3, null, 1, 5] Output: 3
 * Example 2 : Input root = [ 1, 2, -1, 3, 4] Output: 4
 *
 * */

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));

        while (queue.size() > 0) {
            Pair curr = queue.poll();
            if (curr.maxSoFar <= curr.node.val) {
                numGoodNodes++;
            }

            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
            }

            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
            }
        }
        return numGoodNodes;
    }
}


class Pair {
    public TreeNode node;
    public int maxSoFar;

    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}