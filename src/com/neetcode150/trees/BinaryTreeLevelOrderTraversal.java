package com.neetcode150.trees;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i =0; i< queue.size(); i++){
                TreeNode node  = queue.poll();
                if(node != null){
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(list.size() > 0){
                result.add(list);
            }
        }
        return result;
    }
}


// TC: O(n)  SC: O(n)