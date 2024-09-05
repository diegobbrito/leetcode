package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//    https://leetcode.com/problems/two-sum/

//      My first solution, using brute force
//    Time complexity O(n2)
//    Space Complexity O(n)
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
//      Second solution after watching neetcode video
//    Time complexity O(n)
//    Space Complexity O(n)
//    Use HashMap to have a O(n) time and memory complexity
//    The principle is adding the numbers in the hashmap
//    and check each iteration if the target minus the current value exists in the map
//    This way, when the second value is found, the map will have the first number.
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int size = nums.length;
        for(int i = 0; i < size; i++){
            var difference = target - nums[i];
            if(hashMap.containsKey(difference)){
                return new int[]{hashMap.get(difference), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
