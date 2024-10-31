package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberGoodPairs {
//	https://leetcode.com/problems/number-of-good-pairs/

	//	Time Complexity O(n²)
//	Memory Complexity O(1)
	public int numIdenticalPairs(int[] nums) {
		int result = 0;
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int curr = nums[i];
			for (int j = i + 1; j < n; j++)
				if(curr == nums[j])
					result++;
		}
		return result;
	}

	//	Time Complexity O(n)
	//	Memory Complexity O(n)
	public int numIdenticalPairsOptimize(int[] nums) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i : nums) {
			if (map.containsKey(i)) {
				count += map.get(i);
				map.put(i, map.get(i) + 1);
			} else
				map.put(i, 1);
		}
		return count;
	}
}
