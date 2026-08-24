package com.leetcode.trees;

public class SumRootLeafNumbers {

    //https://leetcode.com/problems/sum-root-to-leaf-numbers/

    //Time complexity: O(n), where n is the number of nodes in the tree.
    //We traverse the tree once.
    //Space complexity: O(n), where n is the number of nodes in the tree.

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num){
        if(root == null) return 0;
        num = num * 10 + root.val;
        if(root.left == null && root.right == null) return num;
        return dfs(root.left, num) + dfs(root.right, num);
    }
}
