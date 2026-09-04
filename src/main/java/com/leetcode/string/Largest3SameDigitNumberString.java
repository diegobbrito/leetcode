package com.leetcode.string;

public class Largest3SameDigitNumberString {

    // https://leetcode.com/problems/largest-3-same-digit-number-in-string/
    // Time complexity: O(n)
    // Space complexity: O(1)
    public String largestGoodInteger(String num) {
        String res = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String candidate = num.substring(i, i + 3);
                if (candidate.compareTo(res) > 0) {
                    res = candidate;
                }
            }
        }
        return res;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public String largestGoodInteger2(String num) {
        String[] numbers={"999","888","777","666","555","444","333","222","111","000"};
        for(String str : numbers) {
            if(num.contains(str))
                return str;
        }
        return "";
    }
}
