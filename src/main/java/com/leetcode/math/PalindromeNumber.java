package com.leetcode.math;

public class PalindromeNumber {

//    https://leetcode.com/problems/palindrome-number/

    //    Time complexity: O(n)
//    Space complexity: O(n)
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;

        StringBuilder sb = new StringBuilder();
        String result = "" + x;
        while (x > 0) {
            sb.append(x % 10);
            x /= 10;
        }

        return result.contentEquals(sb.toString());
    }

    //    Time complexity: O(d)
//    Space complexity: O(1)
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;

        int reversed = 0;
        int original = x;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return original == reversed;
    }
}
