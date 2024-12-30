package com.leetcode.greedy;

public class JumpGame {
//    https://leetcode.com/problems/jump-game/

    //  Time complexity: O(n)
//  Space complexity: O(1)
//    The idea is to work backwards from the last index.
//    Keep track of the smallest index that can "jump" to the last index.
//    Check whether the current index can jump to this smallest index.
    public static boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= goal)
                goal = i;
        }
        return goal == 0;
    }
}
