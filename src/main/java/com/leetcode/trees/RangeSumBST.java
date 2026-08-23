package com.leetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumBST {

    //    https://leetcode.com/problems/range-sum-of-bst/
//    Time Complexity O(n)
//    Memory Complexity O(h)
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(new int[1], root, low, high);
    }

    private int dfs(int[] result, TreeNode node, int low, int high) {
        if (node != null) {
            if (node.val >= low && node.val <= high)
                result[0] += node.val;
            if (node.val >= low)
                dfs(result, node.left, low, high);
            if (node.val <= high)
                dfs(result, node.right, low, high);
        }
        return result[0];
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val > high)
            return rangeSumBST2(root.left, low, high);
        if (root.val < low)
            return rangeSumBST2(root.right, low, high);

        return (root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high));
    }

    public int rangeSumBST3(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.val >= low && curr.val <= high){
                    result += curr.val;
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }

        return result;
    }
}
