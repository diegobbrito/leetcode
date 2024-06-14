package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> response = new ArrayList<>();
		if(root == null) return response;

		while (root != null && root.right != null){
			response.add(root.val);
			root = root.right;
		}
		return response;
	}

	public List<Integer> levelOrder(TreeNode root) {
		List<Integer> response = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				TreeNode curr = queue.poll();
				if(curr != null){
					if (curr.left != null)
						queue.offer(curr.left);
					if (curr.right != null)
						queue.offer(curr.right);
					response.add(curr.val);
				}
			}
		}
		return response;
	}
}
