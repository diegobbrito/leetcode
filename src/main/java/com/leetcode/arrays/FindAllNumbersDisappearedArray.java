package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedArray {
//	https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public static void main(String[] args) {
	findDisappearedNumbers(new int[]{1, 2, 3, 4, 5, 5, 6, 7});
}

	//	Time Complexity: O(n²) due to the result.indexOf(num) and result.remove(index),
//	both O(n) operations inside a loop over nums.
//	Space Complexity: O(1) if we ignore the output list, as it modifies nums in place.
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<>(n);
		// Add numbers from 1 to n to the result list
		for (int i = 1; i <= n; i++)
			result.add(i);
		// Remove each number in nums from result list if it exists
		for (int num : nums) {
			var index = result.indexOf(num); // Find the index of num in result
			if (index >= 0)
				result.remove(index); // Remove num if found
		}
		return result;
	}

	//Time Complexity: O(n) as it involves iterating over nums twice.
//Space Complexity: O(1) if we ignore the output list, as it modifies nums in place.
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<>(n);
		// Mark elements as negative to indicate presence
		for (int num : nums) {
			int i = Math.abs(num); // Get the absolute value (ignore if already negative)
			if (nums[i - 1] > 0) // If nums[i - 1] is positive
				nums[i - 1] *= -1;  // Mark as negative to indicate 'i' is present
		}
		// Find indices that are still positive; these represent missing numbers
		for (int i = 0; i < n; i++)
			if (nums[i] > 0)  // If nums[i] is positive, 'i + 1' is missing
				result.add(i + 1);
		return result;
	}

	//Time Complexity: O(n) for filling the auxiliary array and iterating through it.
//Space Complexity: O(n) due to the auxiliary array.
	public List<Integer> findDisappearedNumbers3(int[] nums) {
		int n = nums.length;
		int[] aux = new int[n + 1]; // Auxiliary array to track occurrences
		// Increment count for each number in nums
		for (int num : nums)
			aux[num]++;
		List<Integer> result = new ArrayList<>();
		// Collect numbers that have a count of zero in the aux array
		for (int i = 1; i <= n; i++)
			if (aux[i] == 0)  // If count is zero, 'i' is missing
				result.add(i);
		return result;
	}

}