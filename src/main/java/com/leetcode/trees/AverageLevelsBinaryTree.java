package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {

    //    https://leetcode.com/problems/average-of-levels-in-binary-tree/
//    Time complexity: O(n), where n is the number of nodes in the tree.
//    We traverse the tree once.
//    Space complexity: O(n), where n is the number of nodes in the tree.
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                sum += node.val;
            }
            result.add(sum / size);
        }
        return result;
    }
}
