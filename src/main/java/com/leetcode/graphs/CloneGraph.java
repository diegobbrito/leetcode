package com.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
//    https://leetcode.com/problems/clone-graph/

    //      Time Complexity:
//  DFS Traversal: Each node is visited once, and each edge (connection between nodes) is processed once.
//  Therefore, if there are V nodes and E edges in the graph, the time complexity is O(V + E).
//  V represents the number of nodes, and
//  E represents the number of edges (since each neighbor is processed).
//      Space Complexity:
//  Map Storage: A Map is used to store the reference to the original nodes and their corresponding cloned nodes,
//  so the space required is O(V) (one entry per node).
//  Recursion Call Stack: In the worst case (if the graph is a deep tree-like structure),
//  the recursive call stack will have O(V) depth.
    public Node cloneGraph(Node node) {
        // If the input node is null, return null (base case for an empty graph)
        if (node == null) return null;

        // Create a HashMap to store original nodes and their corresponding cloned nodes
        Map<Node, Node> map = new HashMap<>();

        // Start DFS traversal from the input node to clone the graph
        return dfs(node, map);
    }

    // Helper method for DFS traversal
    private Node dfs(Node node, Map<Node, Node> map) {
        // If the node has already been cloned (present in the map), return the clone
        if (map.containsKey(node)) return map.get(node);

        // Create a new node (clone) with the same value as the original node
        Node copy = new Node(node.val);

        // Store the clone in the map to avoid redundant cloning and to handle cycles
        map.put(node, copy);

        // Recursively clone all the neighbors of the current node
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));  // Recursively clone neighbors and add them to the copy's neighbor list
        }

        // Return the fully cloned node (including its neighbors)
        return copy;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
