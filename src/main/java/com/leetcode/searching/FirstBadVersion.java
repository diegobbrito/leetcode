package com.leetcode.searching;

public class FirstBadVersion {
//	https://leetcode.com/problems/first-bad-version/
//	Time Complexity: O(logn) because the algorithm uses binary search,
//	which divides the search space in half at each step.
//	Space Complexity: The space complexity is O(1)
// 	because the algorithm only uses a constant amount of extra space (for the variables start, end, and middle).
public int firstBadVersion(int n) {
	// Initialize the search range with start at 1 and end at n
	int start = 1, end = n;

	// Perform binary search
	while (start < end) {
		// Calculate the middle index to avoid overflow
		int middle = start + (end - start) / 2;

		// If the middle version is bad, the first bad version must be at 'middle' or earlier
		if (isBadVersion(middle)) {
			end = middle; // Narrow down the search to the left half, including 'middle'
		} else {
			// If the middle version is good, the first bad version must be after 'middle'
			start = middle + 1; // Narrow down the search to the right half, excluding 'middle'
		}
	}

	// When the loop ends, start == end, which is the first bad version
	return start;
}


//	Method provide by the exercise;
	private boolean isBadVersion(int i) {
		return true;
	}
}
