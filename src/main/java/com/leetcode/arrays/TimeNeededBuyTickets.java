package com.leetcode.arrays;

public class TimeNeededBuyTickets {

    //    https://leetcode.com/problems/time-needed-to-buy-tickets/
//    Time complexity: O(n)
//    Space complexity: O(1)
    public int timeRequiredToBuy(int[] tickets, int k) {

        int result = 0;
        int i = 0;
        while (tickets[k] != 0) {
            if (i == tickets.length) {
                i = 0;
            }
            if (tickets[i] == 0) {
                i++;
                continue;
            }
            tickets[i++]--;
            result++;
        }
        return result;
    }
}
