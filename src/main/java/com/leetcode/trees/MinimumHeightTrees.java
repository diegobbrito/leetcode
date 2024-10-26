package com.leetcode.trees;

import java.util.*;

public class MinimumHeightTrees {
//    https://leetcode.com/problems/minimum-height-trees/

    /**
     * Explanation
     * <p>
     * Build Adjacency List:
     * First, create an adjacency list adj for each node, storing its neighbors. Initialize Leaves:
     * Find all nodes with only one connection (degree = 1), these are leaves. Trim Leaves:
     * Iteratively remove leaves and update their neighbors.
     * After removing a leaf, if a neighbor becomes a leaf, add it to the new set of leaves.
     * Continue trimming until only one or two nodes remain, which are the roots of the minimum height trees.
     * Return Result:
     * The remaining nodes in leaves are the roots of the Minimum Height Trees.
     * <p>
     * Complexity Analysis
     * Time Complexity:
     * O(n)
     * Building the adjacency list takes
     * O(n) time since there are n−1 edges.
     * Each node is processed once as a leaf, leading to a linear complexity.
     * Space Complexity: O(n)
     * The adjacency list uses O(n) space, and the list of leaves also takes O(n) in the worst case.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Edge case: If there is only one node, it's the only root for MHT.
        if (n == 1) return Collections.singletonList(0);
        // Step 1: Build the adjacency list for each node.
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // Step 2: Initialize the first layer of leaves.
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) { // A leaf has only one connection.
                leaves.add(i);
            }
        }
        // Step 3: Trim the leaves layer by layer until we reach the root(s).
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            // Remove current leaves.
            for (int leaf : leaves) {
                // There will be exactly one neighbor for a leaf node.
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                // If the neighbor has become a leaf, add it to new leaves.
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        // Remaining nodes are the roots of the Minimum Height Trees.
        return leaves;
    }
}
