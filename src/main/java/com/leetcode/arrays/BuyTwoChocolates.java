package com.leetcode.arrays;

public class LemonadeChange {

    //    https://leetcode.com/problems/buy-two-chocolates/

//    Time complexity: O(nlogn)
//    Space complexity: O(n).

    public int buyChoco(int[] prices, int money) {

        Arrays.sort(prices);
        if(prices[0] + prices[1] <= money){
            return money - (prices[0] + prices[1]);
        }

        return money;
        
    }

}