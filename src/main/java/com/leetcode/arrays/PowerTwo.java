package com.leetcode.arrays;

public class PowerTwo {
    //    https://leetcode.com/problems/power-of-two
//    Time Complexity O(logN)
//    Memory Complexity O(1)
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        while (n > 2){
            if(n % 2 != 0) return false;
            n /= 2;
        }
        if(n == 2) return true;
        return false;
    }
}