package com.leetcode.math;

import java.util.HashSet;
import java.util.Set;

public class TheTwoSneakyNumbersDigitville {

//    https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

    //Time Complexity O(n)
    //Space Complexity O(n)

    public int[] getSneakyNumbers(int[] nums) {
        int[] result = new int[2];
        int k = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.add(i)){
                if(k == 0 ){
                    result[k++] = i;
                } else {
                    result[k] = i;
                    return result;
                }
            }
        }

        return result;
    }
}
