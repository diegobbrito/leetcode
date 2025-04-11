package com.leetcode.arrays;

public class CountSymmetricIntegers {

    //    https://leetcode.com/problems/count-symmetric-integers/

    //Time complexity: O(n)
    //Space complexity: O(1)

    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 != 0) continue;
            int mid = s.length() / 2;
            int first = 0;
            int second = 0;
            for (int j = 0; j < mid; j++) {
                first += s.charAt(j);
                second += s.charAt(j + mid);
            }
            if (first == second) {
                result++;
                i += 8;
            }
        }
        return result;
    }
}
