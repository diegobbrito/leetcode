package com.leetcode.trees;

import java.util.Arrays;

public class ConstructBinaryTreePreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        var root = new TreeNode(preorder[0]);
        int middleIndex = inOrderRootIndex(inorder, preorder[0]);

        root.left = buildTree(
                Arrays.copyOfRange(preorder,1,middleIndex + 1),
                Arrays.copyOfRange(inorder, 0, middleIndex)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder,middleIndex + 1,preorder.length),
                Arrays.copyOfRange(inorder, middleIndex + 1, inorder.length)
        );

        return root;
    }

    private int inOrderRootIndex(int[] inorder, int target) {
        for (int j = 0; j < inorder.length ; j++) {
            if (inorder[j] == target) return j;
        }
        return 0;
    }
}
