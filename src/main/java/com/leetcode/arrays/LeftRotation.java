package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    //https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
    //Time complexity: O(n), Space complexity: O(n)
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        if (a.size() == d) return a;

        List<Integer> result = new ArrayList<>();
        for (int i = d; i < a.size(); i++) {
            result.add(a.get(i));
        }

        for (int i = 0; i < d; i++) {
            result.add(a.get(i));
        }
        return result;
    }
}
