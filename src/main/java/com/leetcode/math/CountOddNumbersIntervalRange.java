package com.leetcode.math;

public class CountOddNumbersIntervalRange {

//    https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

//    Time Complexity O(n)
//    Space Complexity O(1)
    public int countOdds(int low, int high) {
        int result = 0;
        if(low % 2 == 0){
            low++;
        }

        while(low <= high){
            low += 2;
            result++;
        }

        return result;
    }
}
