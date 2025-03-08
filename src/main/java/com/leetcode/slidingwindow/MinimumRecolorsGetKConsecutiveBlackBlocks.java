package com.leetcode.slidingwindow;

public class MinimumRecolorsGetKConsecutiveBlackBlocks {
    //    https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
//    Time: O(n), Space: O(1)
    public int minimumRecolors(String blocks, int k) {

        int b = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') b++;
        }
        int min = k - b;

        for (int right = k, left = 0; right < blocks.length(); right++, left++) {
            if (blocks.charAt(left) == 'B') b--;
            if (blocks.charAt(right) == 'B') b++;
            min = Math.min(min, k - b);
        }

        return min;
    }
}
