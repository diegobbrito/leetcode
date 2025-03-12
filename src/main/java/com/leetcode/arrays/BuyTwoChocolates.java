package com.leetcode.arrays;

import java.util.Arrays;

public class BuyTwoChocolates {

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

//    Time complexity: O(n)
//    Space complexity: O(1).

    public int buyChocoOptimiza(int[] prices, int money) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < first){
                second = first;
                first = prices[i];
            } else if(prices[i] < second){
                second = prices[i];
            }
        }
        if(first + second <= money){
            return money - (first + second);
        }

        return money;
        
    }

}