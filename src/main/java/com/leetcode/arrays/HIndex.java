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


}
