package com.leetcode.trees;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	private TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (val > root.val)
			root.right = insert(root.right, val);
		else if (val < root.val)
			root.left = insert(root.left, val);
		return root;
	}

	private TreeNode minValueNode(TreeNode root) {
		var curr = root;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}

	private TreeNode remove(TreeNode root, int val) {
		if (root == null) return null;
		if (val > root.val)
			root.right = remove(root.right, val);
		else if (val < root.val)
			root.left = remove(root.left, val);
		else {
			if (root.left == null) return root.right;
			else if (root.right == null) return root.left;
			else {
				var minNode = minValueNode(root.right);
				root.val = minNode.val;
				root.right = remove(root.right, root.val);
			}
		}
		return root;
	}
}
