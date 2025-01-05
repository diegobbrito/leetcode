package com.leetcode.trees;

public class CountCompleteTreeNodes {

//    https://leetcode.com/problems/count-complete-tree-nodes/
//    Time complexity: O(n)
//    Space complexity: O(n)

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
