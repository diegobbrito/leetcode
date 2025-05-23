package com.leetcode.searching;

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions {

    //https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
    // Time Complexity O(nlogn)
    // Space Complexity O(n)

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int l = 0, r = potions.length - 1, idx = potions.length;

            while (l <= r) {
                int m = (l + r) / 2;
                if ((long) spells[i] * potions[m] >= success) {
                    r = m - 1;
                    idx = m;
                } else {
                    l = m + 1;
                }
            }

            res[i] = potions.length - idx;
        }

        return res;
    }
}
