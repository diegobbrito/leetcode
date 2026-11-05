package com.leetcode.arrays;

public class TimeNeededBuyTickets {

    //    https://leetcode.com/problems/time-needed-to-buy-tickets/
    //    Time complexity: O(n * m) where n is the length of the tickets array and m is the maximum number of tickets any person has
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

    //    Time complexity: O(n)
    //    Space complexity: O(1)
    public int timeRequiredToBuy2(int[] tickets, int k) {
        int sum = 0;
        int base = tickets[k];
        for(int i = 0; i < tickets.length; i++){
            sum += Math.min(base, tickets[i]);
            if(i == k){
                base--;
            }
        }

        return sum;
    }
}
