package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
//    https://leetcode.com/problems/binary-tree-preorder-traversal/

    //    Time Complexity O(n)
//    Memory Complexity O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return dfs(root, result);
    }

    public List<Integer> dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            dfs(node.left, list);
            dfs(node.right, list);
        }
        return list;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(n)
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                result.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;
            } else
                cur = stack.pop();
        }
        return result;
    }
}
