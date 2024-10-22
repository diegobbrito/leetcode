package com.leetcode.trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorderTraversal {
    //    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//    Time complexity: O(n^2) due to the repeated array slicing and the root index search.
//    Space complexity: O(n^2) because of the recursive call stack and array copying.
        // Base case: If either of the arrays is empty, return null (no tree to build)
        if (preorder.length == 0 || inorder.length == 0) return null;

        // The first element of preorder is always the root of the tree
        var root = new TreeNode(preorder[0]);

        // Find the index of the root in the inorder array (which splits the tree into left and right subtrees)
        int middleIndex = inOrderRootIndex(inorder, preorder[0]);

        // Recursively build the left subtree using the corresponding subarrays from preorder and inorder
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, middleIndex + 1),  // Left subtree's preorder array
                Arrays.copyOfRange(inorder, 0, middleIndex)        // Left subtree's inorder array
        );

        // Recursively build the right subtree using the corresponding subarrays from preorder and inorder
        root.right = buildTree(
                Arrays.copyOfRange(preorder, middleIndex + 1, preorder.length),  // Right subtree's preorder array
                Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length)     // Right subtree's inorder array
        );

        // Return the root of the constructed binary tree
        return root;
    }

    private int inOrderRootIndex(int[] inorder, int target) {
        // Iterate through the inorder array to find the index of the target (root value)
        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == target) return j;  // Return the index of the root
        }
        return 0;  // This should never be reached, as the root value is guaranteed to be in inorder
    }

}

class Solution {
    // Class variable to store the index positions of elements in the inorder array
    private Map<Integer, Integer> inorderPositions;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Initialize the map and populate it with the indices of inorder elements
        inorderPositions = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }

        // Call the recursive helper function with initial indices
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // Base case: if there are no elements to process, return null
        if (preStart > preEnd || inStart > inEnd) return null;

        // The first element of the current preorder range is the root
        TreeNode root = new TreeNode(preorder[preStart]);

        // Get the index of the root in the inorder array using the class-level map
        int rootIndex = inorderPositions.get(preorder[preStart]);

        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndex - inStart;

        // Recursively build the left subtree
        root.left = buildTreeHelper(
                preorder,
                preStart + 1, // The left subtree starts right after the root in preorder
                preStart + leftSubtreeSize, // The left subtree ends after its size
                inorder,
                inStart, // The left subtree is within this range in inorder
                rootIndex - 1
        );

        // Recursively build the right subtree
        root.right = buildTreeHelper(
                preorder,
                preStart + leftSubtreeSize + 1, // The right subtree starts after the left subtree in preorder
                preEnd,
                inorder,
                rootIndex + 1, // The right subtree starts right after the root in inorder
                inEnd
        );

        // Return the root node of the subtree
        return root;
    }
}
