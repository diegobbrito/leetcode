package com.leetcode.slidingwindow;

import java.util.ArrayList;

public class IndexesSubarraySum {

    //https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/

    //Time complexity: O(n), Space complexity: O(1)
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int left = 0;
        int sum = arr[0];

        ArrayList<Integer> result = new ArrayList<>();

        for (int right = 1; right < arr.length; right++) {
            sum += arr[right];
            if (sum == target) {
                result.add(left + 1);
                result.add(right + 1);
                return result;
            } else if (sum > target) {
                sum -= arr[left++];
                sum -= arr[right--];
            }
        }
        result.add(-1);
        return result;
    }


}
