package com.leetcode.trees;

public class SumLeftLeaves {

//    https://leetcode.com/problems/sum-of-left-leaves/
//    Time Complexity O(n)
//    Space Complexity O(n)

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    public int dfs(TreeNode root, boolean left){
        if (root == null) {
            return 0;
        }
        if(left && root.left == null && root.right == null){
            return root.val;
        }
        return dfs(root.left, true) + dfs(root.right, false) ;
    }
}
