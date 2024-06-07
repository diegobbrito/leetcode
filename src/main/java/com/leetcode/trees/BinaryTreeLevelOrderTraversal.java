package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> response = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null)
			queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				TreeNode curr = queue.poll();
				if(curr != null){
					if (curr.left != null)
						queue.offer(curr.left);
					if (curr.right != null)
						queue.offer(curr.right);
					list.add(curr.val);
				}
			}
			response.add(list);
		}
		return response;
	}
}
