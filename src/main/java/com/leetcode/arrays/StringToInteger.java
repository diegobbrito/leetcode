package com.leetcode.arrays;

public class StringToInteger {
    //    https://leetcode.com/problems/string-to-integer-atoi/
//    Time complexity: O(n)
//    Space complexity:O(1)
    public int myAtoi(String s) {
        int len = s.length(), i = 0;
        // Skip leading whitespace characters
        while (i < s.length() && s.charAt(i) == ' ')
            i++;
        // If we reach the end of the string after removing spaces, return 0
        if (i >= len)
            return 0;
        // Check if the number is negative
        boolean negative = s.charAt(i) == '-';
        // If the current character is a sign (+ or -), move to the next character
        if (negative || s.charAt(i) == '+')
            i++;
        // Initialize the response (converted number)
        int response = 0;
        int max = Integer.MAX_VALUE / 10;
        int mod = Integer.MAX_VALUE % 10;
        // Process the digits
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';  // Convert char to int
            // Check for overflow:
            // If adding the next digit will exceed Integer.MAX_VALUE or Integer.MIN_VALUE, return the limit.
            if (response > max || (response == max && digit > mod))
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            // Update the response with the new digit
            response = response * 10 + digit;
            i++;
        }
        // Return the final result, adjusting for negative numbers
        return negative ? -response : response;
    }

}
