package com.leetcode.math;

public class WaterBottles {

    // https://leetcode.com/problems/water-bottles/
    // Time complexity: O(log n)
    // Space complexity: O(1)

    public int numWaterBottles(int numBottles, int numExchange) {

        int result = numBottles;
        int carry = 0;

        while(numBottles > 0){
            carry = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            result += numBottles;
            numBottles += carry;
        }
        return result;
    }
}
