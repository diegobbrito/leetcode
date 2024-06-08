package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
//	https://leetcode.com/problems/binary-tree-inorder-traversal/

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		return list;
	}

	public void inorder(TreeNode root, List<Integer> list) {
		if(root != null){
			inorderTraversal(root.left);
			list.add(root.val);
			inorderTraversal(root.right);
		}
	}
}
