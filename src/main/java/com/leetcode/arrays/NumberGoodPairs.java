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
		// Initialize count to track the number of good pairs
		int count = 0;
		// HashMap to store the frequency of each number in the array
		Map<Integer, Integer> map = new HashMap<>();
		// Iterate through each number in the array
		for (Integer num : nums) {
			// Check if the number has been seen before
			if (map.containsKey(num)) {
				// If it has, add the current frequency of the number to the count
				// This is because each previous occurrence of this number forms a "good pair" with the current one
				count += map.get(num);

				// Increment the frequency of the current number in the map by 1
				map.put(num, map.get(num) + 1);
			} else {
				// If it hasn't been seen, add the number to the map with a frequency of 1
				map.put(num, 1);
			}
		}
		// Return the total count of good pairs
		return count;
	}

}
