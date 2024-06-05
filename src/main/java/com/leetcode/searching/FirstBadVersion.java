package com.leetcode.searching;

public class FirstBadVersion {
//	https://leetcode.com/problems/first-bad-version/
public int firstBadVersion(int n) {
	int left = 1;
	int right = n;

	while(left <  right){
		int middle = left + (right - left) / 2;
		if (isBadVersion(middle)) {
			right = middle;
		} else {
			left = middle + 1;
		}
	}
	return right;
}

//	Method provide by the exercise;
	private boolean isBadVersion(int i) {
		return true;
	}
}
