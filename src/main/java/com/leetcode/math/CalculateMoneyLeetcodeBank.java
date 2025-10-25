package com.leetcode.math;

public class CalculateMoneyLeetcodeBank {

    //https://leetcode.com/problems/calculate-money-in-leetcode-bank/
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public int totalMoney(int n) {
        int result = 0;
        int start = 1;
        int current = 1;

        for(int i = 1; i <= n; i++){
            if(i % 7 == 1 && i != 1){
                current = ++start;
            }
            result += current;
            current++;
        }
        return result;
    }
}
