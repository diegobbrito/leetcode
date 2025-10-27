package com.leetcode.math;

public class NumberLaserBeamsBank {

//    https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
//    Time Complexity: O(n * m) where n is the number of rows and m is the number of columns
//    Space Complexity: O(1)

    public int numberOfBeams(String[] bank) {
        int result = 0;
        int previousDevices = 0;
        for(String row : bank){
            int cur = 0;
            for(char c : row.toCharArray()){
                cur += c - '0';
            }
            if(cur > 0){
                result += previousDevices * cur;
                previousDevices = cur;
            }
        }
        return result;
    }
}
