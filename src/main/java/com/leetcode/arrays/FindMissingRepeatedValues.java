package com.leetcode.arrays;

public class FindMissingRepeatedValues {

    //Time Complexity O(nˆ2)
    //Space Complexity O(nˆ2)

    public int[] findMissingAndRepeatedValues(int[][] grid) {

        Set<Integer> set = new HashSet<>();
        int a = 0;
        int b = 0;
        int n = grid.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!set.add(grid[i][j])){
                    a = grid[i][j];
                }
            }
        }
        for(int i = 1; i <= n * n; i++){
            if(!set.contains(i)){
                b = i;
                break;
            }
        }

        return new int[]{a,b};   
    }

}