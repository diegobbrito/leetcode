package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

class Solution {
// A class to generate all possible subsets of a given set of integers (nums).
// Uses Depth-First Search (DFS) to explore all subsets.
/*
	Time Complexity: O(2^n * n)
	- For each element in the array, there are two possibilities: either it's included in the subset or it's not.
	  This results in 2^n possible subsets.
	- Additionally, for each subset, creating a new list (copying) takes O(n) time in the worst case.
	Thus, the total time complexity is O(2^n * n), where n is the number of elements in the input array.

	Space Complexity: O(n)
	- The recursion depth is limited by the number of elements (n), which results in a recursion stack depth of O(n).
	- The subset list also grows in size up to n elements.
	- Note: The space used for storing the final result is not considered in the space complexity.
*/

	private List<List<Integer>> result; // List to store all subsets
	private int[] nums; // Array to store the input set of integers

	// The main function that generates subsets.
	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>(); // Initialize the result list
		this.nums = nums; // Assign the input array to the class field
		dfs(0, new ArrayList<>()); // Start DFS from the first index with an empty subset

		return result; // Return the final list of subsets
	}

	// Helper function to perform DFS to generate subsets.
	private void dfs(int index, List<Integer> subset) {
		// Base case: if index is out of bounds, add the current subset to the result.
		if (index >= nums.length) {
			result.add(new ArrayList<>(subset)); // Add a copy of the current subset to result
		} else {
			// Include the current element nums[index] in the subset
			subset.add(nums[index]);
			dfs(index + 1, subset); // Recursive call to explore subsets that include nums[index]

			// Exclude the current element nums[index] from the subset
			subset.remove(subset.size() - 1); // Remove the last element (nums[index])
			dfs(index + 1, subset); // Recursive call to explore subsets that don't include nums[index]
		}
	}

}
