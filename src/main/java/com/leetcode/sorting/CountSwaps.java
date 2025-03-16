package com.leetcode.sorting;

import java.util.List;

public class CountSwaps {

//    https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
//    Time complexity: O(n^2), Space complexity: O(1)

    public static void countSwaps(List<Integer> a) {
        int count = 0;
        int n = a.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a.get(j) > a.get(j + 1)) {
                    count++;
                    int temp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temp);
                }
            }
        }
        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(n - 1));
    }
}
