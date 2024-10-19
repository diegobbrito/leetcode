package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
//	https://leetcode.com/problems/binary-tree-right-side-view/
// BFS Solution
/*
	Time Complexity:
	- O(n), where n is the number of nodes in the tree. Every node is visited once.
	Memory Complexity:
	- O(n), as we use a queue to store nodes for BFS. In the worst case,
	the queue can store all nodes in a level (i.e., O(n)).
*/
public List<Integer> rightSideView(TreeNode root) {
	// Result list to store the right side view values
	List<Integer> result = new ArrayList<>();
	// Queue to perform BFS traversal, initialized with the root node
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);  // Add the root node to the queue

	// Perform BFS while the queue is not empty
	while (!queue.isEmpty()) {
		TreeNode node = null;  // This will store the rightmost node at the current level
		int size = queue.size();  // Get the current level size (number of nodes at this level)

		// Loop through all nodes in the current level
		for (int i = 0; i < size; i++) {
			node = queue.poll();  // Remove the node from the queue (FIFO)
			if (node != null) {  // If the node is not null, process its children
				queue.offer(node.left);  // Add left child to the queue (if exists)
				queue.offer(node.right); // Add right child to the queue (if exists)
			}
		}
		// After processing all nodes at the current level, add the rightmost node to the result
		if (node != null) result.add(node.val);
	}

	return result;  // Return the list containing the right-side view
}


	/*
        Time Complexity:
        - O(n), where n is the number of nodes in the tree. Each node is visited once.
        Memory Complexity:
        - O(h), where h is the height of the tree. The memory usage comes from the recursion stack.
        In the worst case (skewed tree), this could be O(n), but for a balanced tree, it's O(log n).
    */
	// Recursion (DFS) Solution
	public List<Integer> rightSideView2(TreeNode root) {
		// List to store the right-side view values
		var list = new ArrayList<Integer>();
		// Call the helper method to perform the recursion
		recursion(root, list, 0);
		return list;  // Return the list containing the right-side view
	}

	private void recursion(TreeNode root, ArrayList<Integer> list, int depth) {
		// Base case: if the node is null, return immediately
		if (root == null) return;

		// If the current depth equals the size of the list, this is the first node seen at this depth
		if (list.size() == depth) list.add(root.val);

		// Recursively visit the right subtree first (to ensure right-side view)
		recursion(root.right, list, depth + 1);
		// Then recursively visit the left subtree
		recursion(root.left, list, depth + 1);
	}


}
