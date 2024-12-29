package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
//    https://leetcode.com/problems/happy-number/

    //    HashSet to store the numbers that have been seen before.
//   Time complexity: O(log n)
//   Space complexity: O(log n)
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (!seen.add(n))
                return false;
            n = sumOfSquares(n);
        }
        return true;
    }

    //    Floyd's cycle detection algorithm is a pointer algorithm that uses two pointers, which move at different speeds.
//    Time complexity: O(log n)
//    Space complexity: O(1)
    public boolean isHappySlowAndFast(int n) {
        int slow = n, fast = sumOfSquares(n);
        while (slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }
        return fast == 1;
    }

    private int sumOfSquares(int value) {
        int sum = 0;
        while (value > 0) {
            int digit = value % 10;
            sum += digit * digit;
            value /= 10;
        }
        return sum;
    }
}
