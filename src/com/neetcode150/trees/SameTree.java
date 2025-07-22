package com.neetcode150.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) {
            return true;
        }

        if ( p != null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        } else {
            return false;
        }
    }

    public boolean isSameTreeStack(TreeNode p, TreeNode q){
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p,q});

        while (!stack.isEmpty()){
            TreeNode[] top = stack.pop();
            TreeNode node1 = top[0], node2 = top[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) return false;
            stack.push(new TreeNode[]{node1.right, node2.right});
            stack.push(new TreeNode[]{node1.left, node2.left});
        }

        return true;
    }


    public boolean isSameTreeBFS(TreeNode p, TreeNode q){
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()){
            for (int i = q1.size(); i > 0; i--){
                TreeNode node1 = q1.poll();
                TreeNode node2 = q2.poll();

                if (node1 == null && node2 == null) continue;
                if (node1 == null || node2 == null || node1.val != node2.val) return false;

                q1.add(node1.left);
                q1.add(node1.right);
                q2.add(node2.left);
                q2.add(node2.right);
            }
        }
        return true;
    }
}
