package com.leetcode.arrays;

public class MinimumChangesToMakeAlternatingBinaryString {
    //    https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
    //    Time Complexity - O(n)
    //    Space Complexity - O(n)
    public int minOperations(String s) {

        char z = '0';
        char o = '1';

        StringBuilder zeroSB = new StringBuilder();
        StringBuilder oneSB = new StringBuilder();

        boolean curr = true;

        for (int i = 0; i < s.length(); i++) {
            if (curr) {
                zeroSB.append(z);
                oneSB.append(o);
                curr = false;
            } else {
                zeroSB.append(o);
                oneSB.append(z);
                curr = true;
            }
        }
        String zero = zeroSB.toString();
        String one = oneSB.toString();

        int startZero = 0;
        int startOne = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != zero.charAt(i)) startZero++;
            if (s.charAt(i) != one.charAt(i)) startOne++;
        }

        return Math.min(startZero, startOne);

    }

    //    Time Complexity - O(n)
    //    Space Complexity - O(1)
    public int minOperations2(String s) {
        int one = 0;
        int zero = 0;
        char curr = '0';
        for(char c : s.toCharArray()){
            if(c == curr)
                one++;
            else
                zero++;
            curr = curr == '0' ? '1' : '0';
        }
        return Math.min(one, zero);
    }
}
