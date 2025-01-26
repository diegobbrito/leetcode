package com.leetcode.arrays;

public class JumpGameII {

//    https://leetcode.com/problems/jump-game-ii/
//    Time complexity: O(n), where n is the number of elements in the input array.
//    Space complexity: O(1)

    public int jump(int[] nums) {
        int result = 0;
        int left = 0, right = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            result++;
        }

        return result;
    }
}
