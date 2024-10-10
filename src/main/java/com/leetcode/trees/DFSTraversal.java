package com.leetcode.trees;

import java.util.List;

public class DFSTraversal {

//	DFS PreOrder
//	Node -> Left -> Right
	public void preorder(TreeNode root, List<Integer> nums){
		if (root != null){
			nums.add(root.val);
			preorder(root.left, nums);
			preorder(root.right, nums);
		}
	}
	//	DFS InOrder
//	 Left -> Node -> Right
	public void inorder(TreeNode root, List<Integer> nums){
		if (root != null){
			inorder(root.left, nums);
			nums.add(root.val);
			inorder(root.right, nums);
		}
	}
	//	DFS PosOrder
//	Left -> Right -> Node
	public void posorder(TreeNode root, List<Integer> nums){
		if (root != null){
			posorder(root.left, nums);
			posorder(root.right, nums);
			nums.add(root.val);
		}
	}
}
