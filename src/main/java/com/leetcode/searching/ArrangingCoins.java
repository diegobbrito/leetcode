package com.leetcode.searching;

public class ArrangingCoins {
    //    Time Complexity O(sqrt(N))
    //    Memory Complexity O(1)
    public int arrangeCoins(int n) {
        int result = 0, start = 1;
        while (n > -1) {
            n -= start;
            start++;
            result++;
        }
        return result - 1;
    }

    //    Time Complexity O(log(N))
    //    Memory Complexity O(1)
    public int arrangeCoins2(int n) {
        long left = 1, right = n;// we use "long" because we may get an integer overflow
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) return (int) mid;
            if (coins > n)
                right = mid - 1;
            else
                left = mid + 1;

        }
        return (int) right;
    }

}
