package com.leetcode.arrays;

public class AverageWaitingTime {

//    https://leetcode.com/problems/average-waiting-time/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public double averageWaitingTime(int[][] customers) {
        double waiting = 0;
        long lastCustomer = 0;

        for(int[] customer : customers){
            lastCustomer = Math.max(lastCustomer, customer[0]) + customer[1];
            waiting += lastCustomer - customer[0];
        }

        return waiting / customers.length;
    }
}
