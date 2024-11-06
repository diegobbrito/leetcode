package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountGoodNodesBinaryTree {
//    https://leetcode.com/problems/count-good-nodes-in-binary-tree/
//Time complexity: O(n)
//Space complexity: O(n)

    //    Depth First Search
    int result;

    public int goodNodes(TreeNode root) {
        result = 0;
        dfs(root, root.val);
        return result;
    }

    private void dfs(TreeNode node, int max) {
        if (node != null) {
            if (node.val < max) {
                dfs(node.left, max);
                dfs(node.right, max);
            } else {
                result++;
                dfs(node.left, node.val);
                dfs(node.right, node.val);
            }
        }
    }

    //Time complexity: O(n)
//Space complexity: O(n)
//    Depth First Search
    class Solution {
        public int goodNodes(TreeNode root) {
            return dfs(root, root.val);
        }

        private int dfs(TreeNode node, int max) {
            if (node == null) return 0;
            if (node.val >= max)
                return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
            return dfs(node.left, max) + dfs(node.right, max);

//            int res = node.val < max ? 0 : 1;
//            max = Math.max(max, node.val);
//            res += dfs(node.left, max);
//            res += dfs(node.right, max);
//            return res;
        }
    }

    //Time complexity: O(n)
    //Space complexity: O(n)
//    Breadth First Search

    class SolutionBFS {
        public int goodNodes(TreeNode root) {
            int result = 0;
            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(root, root.val));
            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> poll = queue.poll();
                TreeNode node = poll.getKey();
                int max = poll.getValue();
                if (node.val >= max) result++;
                if (node.left != null) queue.add(new Pair<>(node.left, Math.max(max, node.val)));
                if (node.right != null) queue.add(new Pair<>(node.right, Math.max(max, node.val)));
            }
            return result;
        }

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
