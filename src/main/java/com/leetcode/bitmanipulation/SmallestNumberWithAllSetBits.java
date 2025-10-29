package com.leetcode.bitmanipulation;

public class SmallestNumberWithAllSetBits {

//    https://leetcode.com/problems/smallest-number-with-all-set-bits/
//    Time Complexity: O(logn)
//    Space Complexity: O(1)

    public int smallestNumber(int n) {
        int i = 1;
        while(i * 2 <= n){
            i *= 2;
        }
        return i * 2 - 1;
    }
}
