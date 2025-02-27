package com.leetcode.math;

public class TheKthFactorN {

    //https://leetcode.com/problems/the-kth-factor-of-n/
    // Time: O(n), Space: O(1)

    public int kthFactor(int n, int k) {

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) k--;
            if (k == 0) return i;
        }

        if (k == 1) return n;

        return -1;
    }
}
