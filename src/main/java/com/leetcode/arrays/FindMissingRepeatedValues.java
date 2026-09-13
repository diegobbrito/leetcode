package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindMissingRepeatedValues {

    //Time Complexity O(nˆ2)
    //Space Complexity O(nˆ2)

    public int[] findMissingAndRepeatedValues(int[][] grid) {

        Set<Integer> set = new HashSet<>();

        int n = grid.length;
        int a = 0;
        int b = n * n;

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (!set.add(ints[j])) {
                    a = ints[j];
                }
            }
        }
        while(set.contains(b)){
            b--;
        }

        return new int[]{a,b};   
    }

}