package com.leetcode.arrays;

import java.util.List;

public class NewYearChaos {
    // https://www.hackerrank.com/challenges/new-year-chaos/problem
    // Time complexity: O(n^2), Space complexity: O(1)

    public static void minimumBribes(List<Integer> q) {

        int bribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            int cur = q.get(i);
            if (cur - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, cur - 2); j < i; j++) { // cur - 2 is the max position that the current person can be
                if (q.get(j) > cur)
                    bribes++;
            }
        }

        System.out.println(bribes);
    }
}
