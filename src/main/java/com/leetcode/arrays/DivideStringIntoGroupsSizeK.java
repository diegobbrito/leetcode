package com.leetcode.arrays;

public class DivideStringIntoGroupsSizeK {

    //https://leetcode.com/problems/divide-a-string-into-groups-of-size-k
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public String[] divideString(String s, int k, char fill) {
        int size = s.length() / k;
        if (s.length() % k != 0) {
            size++;
        }
        String[] result = new String[size];
        int start = 0, i = 0;
        for (int end = k; end < s.length(); start += k, end += k, i++) {
            result[i] = s.substring(start, end);
        }
        String last = s.substring(start);
        result[i] = last + String.valueOf(fill).repeat(k - last.length());
        ;
        return result;
    }
}
