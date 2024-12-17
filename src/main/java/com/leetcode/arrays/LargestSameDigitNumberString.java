package com.leetcode.arrays;

public class LargestSameDigitNumberString {
    //    https://leetcode.com/problems/largest-3-same-digit-number-in-string/
//	Time Complexity O(n)
//	Memory Complexity O(1)
    public String largestGoodInteger(String num) {
        String result = "";
        String curr = "";
        for (int i = 0; i < num.length(); i++) {
            if (curr.length() == 3) {
                int currMax = Integer.parseInt(curr);
                if (result.isEmpty()) {
                    result = curr;
                } else if (currMax > Integer.parseInt(result)) {
                    result = curr;
                }
                curr = "" + num.charAt(i);
            } else if (curr.isEmpty()) {
                curr += num.charAt(i);
            } else {
                if (num.charAt(i) == num.charAt(i - 1)) {
                    curr += num.charAt(i);
                } else {
                    curr = "" + num.charAt(i);
                }
            }
        }

        int currMax = curr.length() == 3 ? Integer.parseInt(curr) : -2;
        int max = result.isEmpty() ? -1 : Integer.parseInt(result);
        if (max < currMax) {
            result = curr;
        }
        return result;
    }


    public String largestGoodIntegerOptimize(String num) {
        if (num.contains("999")) return "999";
        if (num.contains("888")) return "888";
        if (num.contains("777")) return "777";
        if (num.contains("666")) return "666";
        if (num.contains("555")) return "555";
        if (num.contains("444")) return "444";
        if (num.contains("333")) return "333";
        if (num.contains("222")) return "222";
        if (num.contains("111")) return "111";
        if (num.contains("000")) return "000";
        return "";
    }

    public String largestGoodIntegerBestSolution(String num) {
        String ans = "";
        for (int i = 2, size = num.length(); i < size; i++) {
            char a = num.charAt(i);
            char b = num.charAt(i - 1);
            char c = num.charAt(i - 2);
            if (a == b && b == c) {
                String curr = num.substring(i - 2, i + 1);
                if (curr.compareTo(ans) > 0) // Check if the new one is larger
                    ans = curr;
            }
        }
        return ans;
    }
}
