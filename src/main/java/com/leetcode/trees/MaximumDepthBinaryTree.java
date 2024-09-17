package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthBinaryTree {
//    https://leetcode.com/problems/maximum-depth-of-binary-tree/

    // DFS Recursive
    // Time complexity O(n)
    // Time complexity O(h): The space complexity depends on the height h of the tree due to the recursive stack.
    // In the worst case (unbalanced tree), the height could be n, so the space complexity becomes O(n).
    // In the best case (balanced tree), the height is log(n), so the space complexity is O(log n).
    public int maxDepth(TreeNode root) {
        // Base case: if the tree is empty, return 0 (no depth)
        if (root == null) return 0;

        // Recursively calculate the depth of the left and right subtree
        var leftSize = maxDepth(root.left);
        var rightSize = maxDepth(root.right);

        // The depth of the tree is the greater of the left or right subtree depth, plus 1 for the current root node
        return Math.max(leftSize, rightSize) + 1;
    }


    // BFS
    // Time complexity O(n)
    // Time complexity O(n)
    public int maxDepthBFS(TreeNode root) {
        // If the tree is empty, return 0 (no depth)
        if (root == null) return 0;
        // Initialize depth and queue for BFS traversal
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Process nodes level by level
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = queue.size();
            // Process each node at the current level
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                // Add the left and right children of the current node to the queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // Increment depth after processing all nodes at the current level
            depth++;
        }
        // Return the maximum depth after processing all levels
        return depth;
    }

    // DFS Iterative
    // Time complexity O(n)
    // Time complexity O(n)
    public int maxDepthIterativeDFS(TreeNode root) {
        // If the tree is empty, return 0
        if (root == null) return 0;

        // Stack to hold pairs of (node, current depth)
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));  // Start with the root node and depth 1

        int maxDepth = 0;

        // Iterate until the stack is empty
        while (!stack.isEmpty()) {
            // Pop the top pair from the stack
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int currentDepth = current.getValue();

            // Update the maximum depth encountered so far
            maxDepth = Math.max(maxDepth, currentDepth);

            // Push the left child with incremented depth, if it exists
            if (node.left != null) {
                stack.push(new Pair<>(node.left, currentDepth + 1));
            }

            // Push the right child with incremented depth, if it exists
            if (node.right != null) {
                stack.push(new Pair<>(node.right, currentDepth + 1));
            }
        }

        // Return the maximum depth after exploring all nodes
        return maxDepth;
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
