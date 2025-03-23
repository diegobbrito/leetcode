package com.leetcode.arrays;

import java.util.Comparator;
import java.util.List;

public class MinimumAbsoluteDifferenceArray {

//    https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem


    //Brute force
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                min = Math.min(min, Math.abs(arr.get(i) - arr.get(j)));
            }
        }
        return min;
    }

    //Optimized
    //Time complexity: O(nlogn)
    //Space complexity: O(1)
    public static int minimumAbsoluteDifference2(List<Integer> arr) {
        arr.sort(Comparator.comparingInt(a -> a));
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            min = Math.min(min, Math.abs(arr.get(i) - arr.get(i - 1)));
        }
        return min;
    }
}
