package com.leetcode.math;

public class CheckIfDigitsAreEqualStringAfterOperationsI {

//    https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/
//    Time Complexity O(n2)
//    Space Complexity O(n)

    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            StringBuilder curr = new StringBuilder();
            for(int l = 0, r = 1; r < s.length(); l++, r++){
                curr.append((s.charAt(l) - '0' + s.charAt(r) - '0') % 10);
            }
            s = curr.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}
