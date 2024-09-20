package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	//	https://leetcode.com/problems/binary-tree-level-order-traversal/
//Time Complexity: O(n), where n is the number of nodes in the tree.
//The BFS traversal visits each node exactly once, performing a constant amount of work (adding children to the queue,
// adding values to lists) for each node.
//Space Complexity: O(n), where n is the number of nodes in the tree.
//The queue will store at most one level of the tree at a time, which could be up to n/2 nodes in a complete binary tree
// (half of the nodes are at the last level).
//The result list also stores all n nodes across various lists.
	public List<List<Integer>> levelOrder(TreeNode root) {
		// The response list will store lists of integers, each representing the values at each level of the tree.
		List<List<Integer>> response = new ArrayList<>();
		// The queue will be used to perform a Breadth-First Search (BFS) on the tree.
		Queue<TreeNode> queue = new LinkedList<>();
		// If the root is not null, add it to the queue to start the BFS traversal.
		if (root != null)
			queue.add(root);
		// Continue the BFS until the queue is empty, meaning all nodes have been processed.
		while (!queue.isEmpty()) {
			// List to store the values of the current level.
			List<Integer> list = new ArrayList<>();
			// We store the current size of the queue, which represents the number of nodes at this level.
			int queueSize = queue.size();
			// Process each node at the current level.
			for (int i = 0; i < queueSize; i++) {
				// Remove the node from the front of the queue.
				TreeNode curr = queue.poll();
				if (curr != null) {
					// Add the left/right child to the queue if it exists.
					if (curr.left != null) queue.offer(curr.left);
					if (curr.right != null) queue.offer(curr.right);
					// Add the value of the current node to the list for this level.
					list.add(curr.val);
				}
			}
			// Add the list representing the current level to the response list.
			response.add(list);
		}
		// Return the list of lists, each containing the values of nodes at each level.
		return response;
	}

}
