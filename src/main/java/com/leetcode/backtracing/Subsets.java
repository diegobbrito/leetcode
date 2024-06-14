package com.leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
//	https://leetcode.com/problems/subsets/

	public static void main(String[] args) {
		int[] test = {1,2,3};
		subsets(test);
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> response =  new ArrayList<>();
		response.add(List.of());
		List<Integer> aux = new ArrayList<>();
		rootToLeaf(nums, 0, aux, response);
		return response;
	}

	private static void rootToLeaf(int[] nums, int i, List<Integer> aux, List<List<Integer>> response) {
		if(nums.length == 0 || i >= nums.length) return;
		aux.add(nums[i]);
		response.add(List.of(nums[i]));
		response.add(List.copyOf(aux));

		i++;
		rootToLeaf(nums, i, aux, response);
	}

}
