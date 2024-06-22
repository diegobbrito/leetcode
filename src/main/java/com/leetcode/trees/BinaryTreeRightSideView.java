package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
//	https://leetcode.com/problems/binary-tree-right-side-view/
//	BFS Solution
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> response = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode rightSide = null;
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				TreeNode curr = queue.poll();
				if(curr != null){
					rightSide = curr;
					if (curr.left != null)
						queue.offer(curr.left);
					if (curr.right != null)
						queue.offer(curr.right);
				}
			}
			if (rightSide != null)
				response.add(rightSide.val);
		}

		return response;
	}
}
