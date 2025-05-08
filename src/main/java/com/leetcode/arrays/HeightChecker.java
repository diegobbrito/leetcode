package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int h : heights) {
            count[h]++;
        }

        List<Integer> expected = new ArrayList<>();
        for (int h = 1; h <= 100; h++) {
            int c = count[h];
            for (int i = 0; i < c; i++) {
                expected.add(h);
            }
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected.get(i)) {
                res++;
            }
        }

        return res;
    }
}
