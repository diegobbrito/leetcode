package com.leetcode.searching;

public class FirstBadVersion {
//	https://leetcode.com/problems/first-bad-version/
	public int firstBadVersion(int n) {
		if(isBadVersion(1)) return 1;

		int left = 2;
		int right = n;
		int middle = left + (right - left) / 2;
		boolean badVersion = isBadVersion(middle);
		boolean goodVersion = isBadVersion(middle - 1);
		while(badVersion && goodVersion || !badVersion && !goodVersion){
			if(badVersion){
				right = middle - 1;
			}else{
				left = middle + 1;
			}
			middle = left + (right - left) / 2;
			badVersion = isBadVersion(middle);
			goodVersion = isBadVersion(middle - 1);
		}
		return middle;
	}

//	Method provide by the exercise;
	private boolean isBadVersion(int i) {
		return true;
	}
}
