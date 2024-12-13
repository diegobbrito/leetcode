package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //    https://leetcode.com/problems/pascals-triangle/
//    Time complexity: O(n2)
//    Space complexity: O(n2)
//    Dynamic Programming
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i) curr.add(1);
                else curr.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            result.add(curr);
        }
        return result;
    }
}
