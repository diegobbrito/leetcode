package com.leetcode.arrays;

public class MaximumAreaLongestDiagonalRectangle {
//    https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagonal = 0;

        for(int[] rectangle : dimensions){
            int length = rectangle[0];
            int width = rectangle[1];
            int diagonal = length * length + width * width;
            if(diagonal > maxDiagonal){
                maxArea = length * width;
                maxDiagonal = diagonal;
            } else if(diagonal == maxDiagonal && length * width > maxArea){
                maxArea = length * width;
            }
        }

        return maxArea;
    }
}
