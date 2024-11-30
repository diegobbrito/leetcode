package com.leetcode.trees;

public class ConvertSortedArrayBinarySearchTree {

    //    https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBinaryTree(0, nums.length - 1, nums);
    }

    private TreeNode createBinaryTree(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;

        var root = new TreeNode(nums[mid]);
        root.left = createBinaryTree(left, mid - 1, nums);
        root.right = createBinaryTree(mid + 1, right, nums);

        return root;
    }
}
