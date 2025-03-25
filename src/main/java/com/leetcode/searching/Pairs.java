package com.leetcode.searching;

import java.util.Collections;
import java.util.List;

public class Pairs {

    //https://www.hackerrank.com/challenges/pairs/problem
    //Time complexity: O(nlogn)
    //Space complexity: O(1)
    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int left = 0, right = 1, result = 0;
        while (right < arr.size()) {
            int diff = arr.get(right) - arr.get(left);
            if (diff == k) {
                result++;
                left++;
                right++;
            } else if (diff < k)
                right++;
            else
                left++;
            if (left == right)
                right++;
        }
        return result;
    }
}
