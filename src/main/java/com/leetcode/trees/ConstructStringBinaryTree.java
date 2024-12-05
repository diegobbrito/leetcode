package com.leetcode.trees;

public class ConstructStringBinaryTree {
    //    https://leetcode.com/problems/construct-string-from-binary-tree/
//    Time Complexity O(n)
//    Memory Complexity O(n)
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val);
            if (node.left != null)
                sb.append("(");

            dfs(node.left, sb);
            if (node.right != null) {
                if (node.left == null)
                    sb.append("()(");
                else
                    sb.append("(");
            }
            dfs(node.right, sb);
            sb.append(")");
        }
    }
}
