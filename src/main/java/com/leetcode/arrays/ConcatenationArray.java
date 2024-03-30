package com.leetcode.arrays;

public class ConcatenationArray {

//	https://leetcode.com/problems/concatenation-of-array/description/
	public int[] getConcatenation(int[] nums) {
		int[] ans = new int[nums.length * 2];
		for(int i = 0; i < nums.length; i++){
			ans[i] = nums[i];
			ans[nums.length + i] = nums[i];
		}
		return ans;
	}
}
