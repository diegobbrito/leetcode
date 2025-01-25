package com.leetcode.arrays;

public class BestTimeBuySellStockII {
    //    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

    //    Time complexity: O(n), where n is the number of elements in the input array.
    //    Space complexity: O(1)
    public int maxProfit(int[] prices) {
        var profit = 0;
        for (var i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
