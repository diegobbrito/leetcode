package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNodeII {

    //Time complexity: O(n)
    //Space complexity: O(n)
    public Node connect(Node root) {

        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node right = null;
            for (int i = 0; i < size; i++) {
                var curr = queue.poll();
                curr.next = right;
                right = curr;
                if (curr.right != null) queue.offer(curr.right);
                if (curr.left != null) queue.offer(curr.left);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    ;
}
