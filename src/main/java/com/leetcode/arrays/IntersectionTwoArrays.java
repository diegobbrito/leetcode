package com.leetcode.arrays;

public class IntersectionTwoArrays {
    //https://leetcode.com/problems/intersection-of-two-arrays/

    // Time Complexity O(n + m)
    // Space Complexity O(n + m)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        int count = 0;
        for(int i : nums2){
            set2.add(i);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : set2){
            if(!set1.add(i)){
                set.add(i);
            }
        }
        int []result = new int[set.size()];
        int i = 0;
        for(int value : set){
            result[i++] = value;
        }
        return result;
    }

}