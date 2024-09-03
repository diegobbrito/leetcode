package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedArray {
//	https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public static void main(String[] args) {
	findDisappearedNumbers(new int[]{1,2,3,4,5,5,6,7});
}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<>(n);

		for (int i = 1; i < n; i++) {
			result.add(i);
		}
		for (int num : nums) {
			var index = result.indexOf(num);
			if(index >=0 )
				result.remove(index);
		}
		return result;
	}

	public List<Integer> findDisappearedNumbers2(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<>(n);

		for (int num : nums) {
			int i = Math.abs(num);
			if(nums[i - 1] > 0)
				nums[i - 1] *= - 1;
		}
		for (int i = 0; i < n; i++) {
			if(nums[i] > 0)
				result.add(i + 1);
		}

		return result;
	}

}