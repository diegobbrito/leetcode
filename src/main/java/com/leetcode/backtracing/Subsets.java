package com.leetcode.backtracing;

import java.util.*;

public class Subsets {
//	https://leetcode.com/problems/subsets/

	public static void main(String[] args) {
		int[] test = {1,2,3};
		subsets(test);
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> response =  new ArrayList<>();
		Stack<Integer> subSet = new Stack<>();
		dfs(nums, 0, subSet, response);
		return response;
	}

	private static void dfs(int[] nums, int i, Stack<Integer> subset, List<List<Integer>> response) {
		if(i >= nums.length) {
			response.add(List.copyOf(subset));
			return;
		}

		// add the element and start the  recursive call
		subset.add(nums[i]);
		dfs(nums, i + 1, subset, response);
		// remove the element and do the backtracking call.
		subset.pop();
		dfs(nums, i + 1, subset, response);
	}

}
