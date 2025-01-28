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

    //    Greedy solution.
//    Time complexity: O(n), where n is the number of elements in the input list.
//    Space complexity: O(n), where n is the number of elements in the input list.
    public int canCompleteCircuitOptimize(int[] gas, int[] cost) {
        int size = gas.length;
        int[] diff = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if (sum < 0) return -1; // if the total sum of diff is negative, then there is no solution.
        int total = 0;
        int result = 0;
        for (int i = 0; i < size; i++) {
            total += diff[i];
            if (total < 0) {
                total = 0; // if the total sum of diff is negative, then the current start point is not the solution.
                result = i + 1; // update the start point.
            }
        }
        return result;
    }

    //    Greedy solution without extra space
//    Time complexity: O(n), where n is the number of elements in the input list.
//    Space complexity: O(1).
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int currGas = 0, totalGas = 0, result = 0;
        for (int i = 0, size = gas.length; i < size; i++) {
            currGas += gas[i] - cost[i]; // calculate the current gas.
            if (currGas < 0) { // if the current gas is negative, then update the start point.
                totalGas += currGas; // add the current gas to the total gas.
                currGas = 0; // reset the current gas.
                result = i + 1; // update the start point.
            }
        }
        totalGas += currGas;
        return totalGas >= 0 ? result : -1;
    }

}
