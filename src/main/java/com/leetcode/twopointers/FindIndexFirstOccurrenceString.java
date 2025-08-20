package com.leetcode.twopointers;

public class FindIndexFirstOccurrenceString {
//	https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public static void main(String[] args) {
	System.out.println(strStr("mississippi","pi"));
}
	// Time complexity: O(n*m) n is the size of haystack and m is the size of needle
    // Space complexity: O(1)
    public static int strStr(String haystack, String needle) {
		int needleSize = needle.length();
		int hayStackSize = haystack.length();
		if(hayStackSize < needleSize) return -1;

		int needleIndex = 0, haystackIndex = 0;

		while(haystackIndex < hayStackSize){
			if(haystack.charAt(haystackIndex) == needle.charAt(needleIndex)){
				while(haystackIndex < hayStackSize
						&& needleIndex < needleSize
						&& haystack.charAt(haystackIndex) == needle.charAt(needleIndex)){
					haystackIndex++;
					needleIndex++;
				}
				if(needleIndex == needleSize)
					return haystackIndex - needleSize;
				else{
					haystackIndex -= needleIndex;
					needleIndex = 0;
				}
			}
			haystackIndex++;
		}
		return -1;
	}

    // Using built-in function
    // Time complexity: O(n*m) n is the size of haystack and m is the size of needle
    // Space complexity: O(1)
	public int strStr2(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
}
