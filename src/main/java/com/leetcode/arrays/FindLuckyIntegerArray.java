package com.leetcode.arrays;

public class FindLuckyIntegerArray {
//    https://neetcode.io/problems/find-lucky-integer-in-an-array/
//    Time Complexity O(n)
//    Memory Complexity O(n)

    public int findLucky(int[] arr) {
        int[] count = new int[arr.length + 1];

        for(int i : arr){
            if(i < count.length) count[i]++;
        }

        for(int i = arr.length; i > 0; i--){
            if(i == count[i]){
                return i;
            }
        }

        return -1;
    }
}
