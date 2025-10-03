package com.leetcode.math;

public class WaterBottles {

    // https://leetcode.com/problems/water-bottles/
    // Time complexity: O(log n)
    // Space complexity: O(1)

    public int numWaterBottles(int numBottles, int numExchange) {

        int result = numBottles;
        int carry = 0;

        while(numBottles >= numExchange){
            carry = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            result += numBottles;
            numBottles += carry;
        }
        return result;
    }

    // Mathematical approach
    // Time complexity: O(1)
    // Space complexity: O(1)

    public int numWaterBottles2(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
