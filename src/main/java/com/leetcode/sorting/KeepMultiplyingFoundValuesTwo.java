package com.leetcode.sorting;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesTwo {

//    https://leetcode.com/problems/keep-multiplying-found-values-by-two
//    Time Complexity O(n)
//    Space Complexity O(n)

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        while(set.contains(original)){
            original *= 2;
        }

        return original;
    }
}
