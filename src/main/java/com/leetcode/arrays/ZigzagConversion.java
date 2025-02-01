package com.leetcode.arrays;

public class ZigzagConversion {

//    https://leetcode.com/problems/zigzag-conversion/

    // Time complexity: O(n)
    // Space complexity: O(n)

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        StringBuilder sb = new StringBuilder();

        int size = s.length();
        for (int row = 0; row < numRows; row++) {
            int increment = 2 * (numRows - 1); // 2 * (numRows - 1) is the distance between the first element of the row and the second element of the row
            for (int i = row; i < size; i += increment) { // i += increment is the distance between the first element of the row and the first element of the next row
                sb.append(s.charAt(i));
                if (row > 0 && row < numRows - 1 && i + increment - 2 * row < size) { // if row is not the first or the last row, we need to add the second element of the row
                    sb.append(s.charAt(i + increment - 2 * row)); // i + increment - 2 * row is the distance between the first element of the row and the second element of the row
                }
            }
        }

        return sb.toString();
    }
}
