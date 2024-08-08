package com.leetcode.arrays;

public class CanPlaceFlowers {
    //    https://leetcode.com/problems/can-place-flowers/
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers2(new int[]{1, 0, 0, 1}, 1));
        canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2);
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0;
        int before = 0;
        int size = flowerbed.length;
        while (n > 0 && i < size) {
            if (flowerbed[i] == 1) {
                i++;
                before = 1;
                continue;
            }
            if (before == 1) {
                before = 0;
                i++;
                continue;
            }
            if (i == size - 1) {
                if (before == 0)
                    n--;
                break;
            }

            if (flowerbed[i + 1] == 0) {
                n--;
                before = 1;
            } else
                before = flowerbed[i];
            i++;
        }
        return n == 0;
    }

    //    Time Complexity O(n)
    //    Memory Complexity O(1)
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        // Initialize index and size of flowerbed
        int i = 0;
        int size = flowerbed.length;

        // Loop through the flowerbed until we have no more flowers to plant or reach the end
        while (n > 0 && i < size) {
            // If current spot is occupied, skip it and the next one
            if (flowerbed[i] == 1)
                i += 2;
            // If current spot and the next one are both empty, plant a flower
            else if (i == size - 1 || flowerbed[i + 1] == 0) {
                n--; // Plant a flower
                i += 2; // Move two spots forward
            }
            // If the next spot is occupied, just skip this spot
            else
                i++;
        }

        // If we have planted all flowers, return true, otherwise return false
        return n == 0;
    }

}
