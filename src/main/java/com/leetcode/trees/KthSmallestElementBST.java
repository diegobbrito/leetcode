package com.leetcode.trees;

import java.util.*;

public class KthSmallestElementBST {
    //    https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> response = new ArrayList<>();
        inOrder(root, response);
        return response.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> response) {
        if(root == null) return;
        inOrder(root.left, response);
        response.add(root.val);
        inOrder(root.right, response);
    }

    /**
     * Time Complexity: O(N + k log N)
     * - N for the in-order traversal to add each node to the priority queue.
     * - k * log(N) for polling (k-1) times to find the k-th smallest element.
     * <p>
     * Space Complexity: O(N)
     * - N space for the priority queue to store all nodes.
     */
    // Approach using a priority queue (min-heap) to store nodes in sorted order.
    class Solution {
        PriorityQueue<Integer> pq; // Priority queue to store values in ascending order

        public int kthSmallest(TreeNode root, int k) {
            // Initialize priority queue with a comparator for integers in ascending order
            pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

            // Perform in-order traversal to add elements to the priority queue
            bfs(root);

            // Remove (k-1) smallest elements to get the k-th smallest element
            for (int i = 0; i < k - 1; i++) {
                pq.poll(); // Poll removes the smallest element in the min-heap
            }

            return pq.poll(); // Poll the k-th smallest element
        }

        // Recursive in-order traversal (left-root-right) to ensure sorted order in BST
        private void bfs(TreeNode node) {
            if (node != null) {
                bfs(node.left);
                pq.add(node.val); // Add each node’s value to the priority queue
                bfs(node.right);
            }
        }
    }


    /**
     * Time Complexity: O(H + k)
     * - H for height of the tree to reach the k-th node in the in-order traversal.
     * - k as we may need to visit up to k nodes to find the k-th smallest.
     * <p>
     * Space Complexity: O(H)
     * - O(H) space for the recursion stack in the in-order traversal.
     */
// Optimized approach using in-order traversal without extra space.
    class SolutionOptimize {
        int current; // Counter for the current node visited in in-order traversal
        int k; // Target k for finding the k-th smallest element
        int response; // Variable to store the k-th smallest element

        public int kthSmallest(TreeNode root, int k) {
            current = 0;
            this.k = k;
            bfs(root); // Perform in-order traversal
            return response; // Return the k-th smallest element
        }

        // Recursive in-order traversal to count nodes as we go
        private void bfs(TreeNode node) {
            if (node != null) {
                bfs(node.left); // Traverse left subtree

                current++; // Increment count on visiting each node
                if (current == k) { // Check if current node is the k-th smallest
                    response = node.val;
                    return; // Stop traversal once we find the k-th smallest element
                }

                bfs(node.right); // Traverse right subtree
            }
        }
    }

    /**
     * Time Complexity: O(H + k)
     * - We perform an in-order traversal, which takes up to H steps to reach the leftmost node.
     * - We then traverse up to k nodes to find the k-th smallest element.
     * <p>
     * Space Complexity: O(H)
     * - The maximum depth of the stack will be the height of the tree, H.
     */
    class SolutionIterative {


        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>(); // Stack to store nodes for in-order traversal
            var cur = root; // Initialize current node as root
            int n = 0; // Counter for the number of nodes processed

            // Iterate until we process all nodes or find the k-th smallest
            while (cur != null || !stack.isEmpty()) {
                // Reach the leftmost node of the current subtree
                while (cur != null) {
                    stack.push(cur); // Push current node to stack
                    cur = cur.left; // Move to left child
                }

                // Process the node at the top of the stack
                cur = stack.pop();
                n++; // Increment the count of nodes visited
                if (n == k) return cur.val; // If we've reached the k-th node, return its value

                // Move to the right subtree
                cur = cur.right;
            }

            return -1; // Return -1 if k is out of bounds (though typically unreachable if k is valid)
        }


    }




}


