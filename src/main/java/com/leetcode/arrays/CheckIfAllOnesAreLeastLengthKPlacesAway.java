package com.leetcode.arrays;

public class CheckIfAllOnesAreLeastLengthKPlacesAway {

//    https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
//    Time Complexity O(n)
//    Space Complexity O(1)
    public boolean kLengthApart(int[] nums, int k) {
        int lastOnePosition = 0;
        while(lastOnePosition < nums.length && nums[lastOnePosition] == 0){
            lastOnePosition++;
        }

        for(int i = lastOnePosition + 1; i < nums.length; i++){
            if(nums[i] == 1){
                if(i - lastOnePosition - 1 < k){
                    return false;
                }
                lastOnePosition = i;
            }
        }
        return true;
    }
}
