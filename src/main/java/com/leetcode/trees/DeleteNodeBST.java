package com.leetcode.trees;

public class DeleteNodeBST {
//	https://leetcode.com/problems/delete-node-in-a-bst/description/

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		if(key > root.val)
			root.right = deleteNode(root.right, key);
		else if(key < root.val)
			root.left = deleteNode(root.left, key);
		else {
			if (root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else{
				var minNode = findMin(root.right);
				root.val = minNode.val;
				root.right = deleteNode(root.right, minNode.val);
			}
		}
		return root;
	}

	/*
	To find the minimum value in a Binary Search Tree, it's just go to the left until the last leaf node
	* */
	private TreeNode findMin(TreeNode node){
		var curl = node;
		while (curl != null && curl.left != null){
			curl = curl.left;
		}
		return curl;
	}
}
