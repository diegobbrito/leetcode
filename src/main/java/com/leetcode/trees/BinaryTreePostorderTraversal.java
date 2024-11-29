package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    //    https://leetcode.com/problems/binary-tree-postorder-traversal/
//    Time Complexity O(n)
//    Memory Complexity O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            dfs(node.right, list);
            list.add(node.val);
        }
        return list;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(n)
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        stack.push(root);
        visit.push(false);
        while (!stack.isEmpty()) {
            var cur = stack.pop();
            var visited = visit.pop();
            if (cur != null) {
                if (visited) {
                    list.add(cur.val);
                } else {
                    stack.push(cur);
                    visit.push(true);
                    stack.push(cur.right);
                    visit.push(false);
                    stack.push(cur.left);
                    visit.push(false);
                }
            }

        }
        return list;
    }
}
