package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceTwoArrays {

    //    https://leetcode.com/problems/find-the-difference-of-two-arrays/
//    TC O(n+m)
//    SC O(n+m)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(getList(nums1, nums2));
        answer.add(getList(nums2, nums1));
        return answer;
    }

    private List<Integer> getList(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);
        for (int num : nums2)
            set.remove(num);
        return new ArrayList<>(set);
    }
}
