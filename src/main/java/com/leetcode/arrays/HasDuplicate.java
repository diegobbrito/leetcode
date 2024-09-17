package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicate {
//	https://leetcode.com/problems/contains-duplicate/

	//	Time Complexity O(n)
//	Memory Complexity O(n)
	public boolean hasDuplicate(int[] nums) {
		Set<Integer> hashSet = new HashSet<>();
		for (int num : nums) {
			if (!hashSet.add(num)) return true;
		}
		return false;
	}
}
