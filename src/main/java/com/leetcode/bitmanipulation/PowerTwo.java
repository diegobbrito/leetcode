package com.leetcode.bitmanipulation;

public class PowerTwo {

//    https://neetcode.io/problems/power-of-two/
//    Time Complexity O(1)
//    Space Complexity O(1)

//    0011 3
//    0100 4
//    4 & 3 = 0000

//    0111 7
//    1000 8
//    8 & 7 = 0000
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
}
