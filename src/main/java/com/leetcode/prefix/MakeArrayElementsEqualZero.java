package com.leetcode.prefix;

public class MakeArrayElementsEqualZero {

//    https://leetcode.com/problems/make-array-elements-equal-to-zero/
//    Time Complexity: O(n)
//    Space Complexity: O(n)

    public int countValidSelections(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] posfix = new int[len];
        int pre = 0, pos = 0;;
        for(int i = 0, j = len - 1; i < len; i++, j--){
            pre += nums[i];
            pos += nums[j];
            prefix[i] = pre;
            posfix[j] = pos;
        }

        int result = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                int diff = Math.abs(posfix[i] - prefix[i]);
                if(diff == 0){
                    result += 2;
                } else if (diff == 1){
                    result++;
                }
            }
        }
        return result;
    }
}
