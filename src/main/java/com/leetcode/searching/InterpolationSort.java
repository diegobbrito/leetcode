package com.leetcode.searching;

public class InterpolationSort {

//	Average case: O(log(log(n))
//	Worst case: O(n) when values increase exponentially
	public int search(int[] array, int target){
		int left = 0;
		int right = array.length - 1;
		while( target >= array[left] && target <= array[right] &&  left <= right){
			int probe = left + (right - left) * (target - array[left]) / (array[right] - array[left]);
			if(array[probe] == target)
				return probe;
			else if (array[probe] < target)
				left = probe + 1;
			else
				right = probe + 1;
		}

		return -1;
	}
}
