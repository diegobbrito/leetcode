package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeBinaryTree {
    //    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    private int i; // Index for traversing serialized values during deserialization.
    private List<String> list; // List to store serialized tree values.

    // Encodes a binary tree to a single string.
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(n), to store the serialized values in the list.
    public String serialize(TreeNode root) {
        list = new ArrayList<>();
        preOrder(root); // Perform pre-order traversal to build the serialized string.
        return String.join(",", list); // Join the list values with commas to create a single string.
    }

    // Helper method to perform pre-order traversal and serialize the tree.
    // Time Complexity: O(n), as each node is visited once.
    private void preOrder(TreeNode node) {
        if (node == null) {
            list.add("N"); // Use "N" to represent null nodes.
        } else {
            list.add(String.valueOf(node.val)); // Add current node's value.
            preOrder(node.left); // Traverse left subtree.
            preOrder(node.right); // Traverse right subtree.
        }
    }

    // Decodes your encoded data to tree.
    // Time Complexity: O(n), where n is the number of nodes in the tree.
    // Space Complexity: O(n), for the array of values created by splitting the string.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null; // Return null if the input string is empty.
        String[] values = data.split(","); // Split the serialized string into an array of values.
        i = 0; // Initialize index for traversal.
        return preOrderDeserialize(values); // Start deserialization using pre-order traversal.
    }

    // Helper method for pre-order deserialization.
    // Time Complexity: O(n), as each value is processed once.
    private TreeNode preOrderDeserialize(String[] values) {
        if ("N".equals(values[i])) { // Check if the current value is "N" (null).
            i++; // Move to the next value.
            return null; // Return null for this node.
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[i++])); // Create a node with the current value.
        node.left = preOrderDeserialize(values); // Recur to build the left subtree.
        node.right = preOrderDeserialize(values); // Recur to build the right subtree.
        return node; // Return the constructed node.
    }
}
