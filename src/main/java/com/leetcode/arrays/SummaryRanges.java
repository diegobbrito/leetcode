package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    //    https://leetcode.com/problems/summary-ranges/
//    Time complexity: O(n), where n is the number of elements in the input array.
//    Space complexity: O(n), where n is the number of elements in the input array.
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int end = 0;
        int size = nums.length;
        String concat = "->";
        while (end < size) {
            int start = end;
            while (end < size - 1 && nums[end + 1] == nums[end] + 1) {
                end++;
            }
            if (start == end)
                result.add(String.valueOf(nums[end]));
            else
                result.add(String.valueOf(nums[start]).concat(concat).concat(String.valueOf(nums[end])));

            end++;
        }
        return result;
    }

}
