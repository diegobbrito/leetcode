package com.leetcode.bitmanipulation;

public class ReverseInteger {
    //    https://leetcode.com/problems/reverse-integer/
    // Time Complexity O(1)
    // Space Complexity O(1)
    public int reverse(int x) {
        
        int MAX = Integer.MAX_VALUE / 10;
        int MODULE_MAX = Integer.MAX_VALUE % 10;
        int MIN = Integer.MIN_VALUE / 10;
        int MODULE_MIN = Integer.MIN_VALUE % 10;

        int result = 0;

        while(x != 0){
            int digit = x % 10;
            x /= 10;
            if(result > MAX || (result == MAX && digit > MODULE_MAX))
                return 0;

            if(result < MIN || (result == MIN && digit < MODULE_MIN))
                return 0;
            result = (result * 10) + digit; 
        }
        
        return result;
    }

}