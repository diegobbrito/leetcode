package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class StringEncodeDecode {

// Time complexity O(n)

    public String encode(List<String> strs) {
        var sb = new StringBuilder();
        // Create a string adding the length of the string a # character and the actual string
        for (var str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
//        To decode process, we check the element with the string length, use the value to get que string and add to the result
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            result.add(str.substring(j + 1, i));
        }
        return result;
    }
}
