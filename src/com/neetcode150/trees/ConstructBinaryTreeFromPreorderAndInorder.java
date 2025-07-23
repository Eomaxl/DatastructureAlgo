package com.neetcode150.trees;

public class ConstructBinaryTreeFromPreorderAndInorder {
    int preIdx = 0;
    int inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {  // TC O(n), SC O(n)
        return dfs(preorder,inorder,Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int max) {
        if(preIdx >= preorder.length) return null;
        if(inorder[inIdx] == max){
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, max);
        return root;
    }
}
