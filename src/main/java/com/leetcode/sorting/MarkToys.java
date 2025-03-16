package com.leetcode.sorting;

import java.util.Comparator;
import java.util.List;

public class MarkToys {

    //https://www.hackerrank.com/challenges/mark-and-toys/problem
    //Time complexity: O(nlogn), Space complexity: O(1)

    public static int maximumToys(List<Integer> prices, int k) {
        prices.sort(Comparator.comparingInt(a -> a));

        int count = 0;
        for (int i : prices) {
            if (k - i < 0) return count;
            k -= i;
            count++;
        }

        return count;
    }
}
