package com.leetcode.arrays;

public class AlternatingCharacters {

//    https://www.hackerrank.com/challenges/alternating-characters/problem

    //Time complexity: O(n)
    //Space complexity: O(1)

    public static int alternatingCharacters(String s) {

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i - 1);
            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
        }
        return count;

    }
}
