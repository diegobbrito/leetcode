package com.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII{
    // https://leetcode.com/problems/contains-duplicate-ii/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length && j < i + k + 1; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }


    public boolean containsNearbyDuplicateOptimize(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(r - l > k){
                set.remove(nums[l]);
                l++;
            }
            if(set.contains(nums[r]))
                return true;
            set.add(nums[r]);
        }
        return false;
    }
}