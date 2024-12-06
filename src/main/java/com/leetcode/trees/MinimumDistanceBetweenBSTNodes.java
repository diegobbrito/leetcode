package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {
    //    https://leetcode.com/problems/minimum-distance-between-bst-nodes/
// Time Complexity O(n)
// Space Complexity O(n)
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int min = Integer.MAX_VALUE;
        int last = Integer.MAX_VALUE;
        for (int i : list) {
            int diff = Math.abs(i - last);
            min = Math.min(min, diff);
            last = i;
        }
        return min;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node != null) {
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }
}
