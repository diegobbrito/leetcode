package com.leetcode.trees;

public class MinimumDepthBinaryTree {

//    https://leetcode.com/problems/minimum-depth-of-binary-tree/
    //Time complexity O(n)
    //Space Complexity O(h)

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if(node.left == null && node.right == null){
            return 1;
        }
        if(node.left == null){
            return 1 + dfs(node.right);
        }
        if(node.right == null){
            return 1 + dfs(node.left);
        }
        return 1 + Math.min(dfs(node.left), dfs(node.right));
    }
}
