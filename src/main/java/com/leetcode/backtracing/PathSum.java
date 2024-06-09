package com.leetcode.backtracing;

import com.leetcode.trees.TreeNode;

public class PathSum {
//	https://leetcode.com/problems/path-sum/
	public boolean hasPathSum(TreeNode root, int targetSum) {
		int sum = 0;
		return rootToLeaf(root, sum, targetSum);
	}

	private static boolean rootToLeaf(TreeNode root, int sum, int targetSum){
		if(root == null) return false;
		sum += root.val;

		if(root.left == null && root.right == null)
			return sum == targetSum;

		return rootToLeaf(root.left, sum, targetSum) || rootToLeaf(root.right, sum, targetSum);
	}
}
