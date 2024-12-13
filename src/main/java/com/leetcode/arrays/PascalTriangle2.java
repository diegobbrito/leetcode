package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle2 {
    //    https://leetcode.com/problems/pascals-triangle-ii/
//    Time complexity: O(n2)
//    Space complexity: O(n2)
//    Dynamic Programming
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    curr.add(1);
                else
                    curr.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(curr);
        }
        return result.get(rowIndex);
    }

    //Dynamic Programming (Space Optimized)
//    Time complexity: O(n2)
//    Space complexity: O(n)
    public List<Integer> getRow2(int rowIndex) {

        List<Integer> row = new ArrayList<>(Collections.nCopies(rowIndex + 1, 1));
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
