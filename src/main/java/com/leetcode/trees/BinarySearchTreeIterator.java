package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator {

//    https://leetcode.com/problems/binary-search-tree-iterator/

    //Time complexity: O(n)
    //Space complexity: O(n)
    static class BSTIterator {

        Queue<Integer> queue;

        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            populateStack(root);
        }

        private void populateStack(TreeNode root) {
            if (root != null) {
                populateStack(root.left);
                queue.offer(root.val);
                populateStack(root.right);
            }
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    //Time complexity: O(h) in balanced tree, O(n) in worst case
    //Space complexity: O(h) in balanced tree, O(n) in worst case
    static class BSTIteratorStack {

        Stack<TreeNode> stack;

        public BSTIteratorStack(TreeNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }


}
