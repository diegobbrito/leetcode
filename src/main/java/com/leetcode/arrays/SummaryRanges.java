package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    //    https://leetcode.com/problems/summary-ranges/
//    Time complexity: O(n), where n is the number of elements in the input array.
//    Space complexity: O(n), where n is the number of elements in the input array.
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int index = 0;
        int size = nums.length;
        String concat = "->";
        while (index < size) {
            int start = index;
            int end = index;
            while (end < size - 1) {
                if (nums[end + 1] != nums[end] + 1) {
                    break;
                }
                end++;
            }
            if (start == end) {
                result.add(String.valueOf(nums[index]));
            } else {
                result.add(String.valueOf(nums[start]).concat(concat).concat(String.valueOf(nums[end])));
            }
            index = end + 1;
        }
        return result;
    }
}
