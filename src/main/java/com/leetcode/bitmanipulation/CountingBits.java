package com.leetcode.bitmanipulation;

public class CountingBits {
    //    https://leetcode.com/problems/counting-bits/
    public static void main(String[] args) {
        countBits(5);
    }

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public int[] countBits2(int n) {
        int[] result = new int[n + 1];
        int offset = 1;
        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) offset = i;
            result[i] = 1 + result[i - offset];
        }
        return result;
    }
}
