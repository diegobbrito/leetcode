package com.leetcode.searching;

public class MinimumTimeRepairCars {

//    https://leetcode.com/problems/minimum-time-to-repair-cars/

    //    Time complexity: O(nlogn)
//    Space complexity: O(1)
    public long repairCars(int[] ranks, int cars) {

        long left = 1;
        long right = (long) 1e14;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepair(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        long sum = 0;
        for (int rank : ranks) {
            long s = time / rank;
            sum += (long) Math.sqrt(s);
            if (sum >= cars) return true;
        }
        return false;
    }
}
