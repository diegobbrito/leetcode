package com.leetcode.arrays;

public class GasStation {

    //    https://leetcode.com/problems/gas-station/
//    Brute force solution.
//    Time complexity: O(n^2), where n is the number of elements in the input list.
//    Space complexity: O(1).
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (canComplete(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canComplete(int start, int[] gas, int[] cost) {
        int c = 0;
        int count = 0;
        while (count < gas.length) {
            c += cost[start];
            if (start + 1 == gas.length) start = 0;
            else start++;
            if (c > gas[start]) return false;
            c -= gas[start];
            count++;
        }
        return true;
    }


}
