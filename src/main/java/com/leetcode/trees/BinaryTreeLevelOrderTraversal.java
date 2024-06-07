package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> response = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) return response;
		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < queue.size(); i++) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			}
			response.add(list);
		}
		return response;
	}
}
