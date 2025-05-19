package com.leetcode.arrays;

public class TypeTriangle {

    //    https://leetcode.com/problems/type-of-triangle/
//  Time Complexity: O(1)
//  Space Complexity: O(1)
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a + b <= c || b + c <= a || a + c <= b) {
            return "none";
        }

        if (a == b && b == c) {
            return "equilateral";
        }
        if (a == b || b == c || a == c) {
            return "isosceles";
        }

        return "scalene";
    }
}
