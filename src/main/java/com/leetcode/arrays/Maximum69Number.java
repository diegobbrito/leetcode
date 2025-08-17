package com.leetcode.arrays;

public class Maximum69Number {

    //Time Complexity O(n)
    //Space Complexity O(1)
    public int maximum69Number (int num) {
        String n = String.valueOf(num);
        return Integer.parseInt(n.replaceFirst("6", "9"));
    }

    //Time Complexity O(n)
    //Space Complexity O(n)
    public int maximum69Number2 (int num) {
        var n = String.valueOf(num).toCharArray();
        for (int i = 0; i < n.length; i++) {
            if (n[i] == '6') {
                n[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(n));
    }
}
