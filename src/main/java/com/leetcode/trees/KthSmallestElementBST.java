package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> response = new ArrayList<>();
        inOrder(root, response);
        return response.get( k - 1 );
    }

    private void inOrder(TreeNode root, List<Integer> response) {
        if(root == null) return;
        inOrder(root.left, response);
        response.add(root.val);
        inOrder(root.right, response);
    }
}
