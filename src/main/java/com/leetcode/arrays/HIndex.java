package com.leetcode.arrays;

import java.util.Arrays;

public class HIndex {

    //    https://leetcode.com/problems/h-index/
//    Time complexity: O(nlogn), where n is the number of elements in the input array.
//    Space complexity: O(1)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            count++;// count the number of papers that have at least citations[i] citations
            result = Math.max(result, Math.min(count, citations[i]));// update the h-index
        }
        return result;
    }

    //    Time complexity: O(nlogn), where n is the number of elements in the input array.
//    Space complexity: O(1)
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) { // if the number of papers that have at least citations[i] citations is greater than or equal to citations[i]
                return citations.length - i; // return the h-index
            }
        }
        return 0;
    }

    //    Time complexity: O(n), where n is the number of elements in the input array.
//    Space complexity: O(n)
    public int hIndexOptimize(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1]; // freq[i] is the number of papers that have i citations

        for (int c : citations) {
            freq[Math.min(n, c)]++; // if the citation is greater than n, then it is counted as n
        }

        int c = 0;

        for (int h = n; h >= 0; h--) {
            c += freq[h]; // c is the number of papers that have at least i citations
            if (c >= h) // if the number of papers that have at least i citations is greater than or equal to i
                return h; // return the h-index
        }

        return 0;
    }

}
