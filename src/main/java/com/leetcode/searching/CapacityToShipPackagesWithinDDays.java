package com.leetcode.searching;

public class CapacityToShipPackagesWithinDDays {

    //    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
//    Binary search
//    Time complexity: O(n * log(sum(weights)))
//    Space complexity: O(1)
    public int shipWithinDays(int[] weights, int days) {
        // Calculate the total weight (count) and the maximum weight of a single package (max).
        // These values will be used to determine the possible range for binary search.
        int count = 0;
        int left = 0;
        for (int w : weights) {
            count += w; // Total weight of all packages
            left = Math.max(left, w); // Maximum weight of a single package
        }

        // The maximum possible capacity is the total weight (count),
        // where all packages are shipped in one day.
        int right = count;

        // Perform binary search to find the minimum capacity needed to ship within the given days.
        while (left < right) {
            int mid = left + (right - left) / 2; // Midpoint capacity
            if (canShip(weights, mid, days)) {
                // If it's possible to ship within 'days' with capacity 'mid',
                // search for a smaller capacity on the left side.
                left = mid + 1;
            } else {
                // Otherwise, search for a larger capacity on the right side.
                right = mid;
            }
        }
        // The left pointer will converge to the minimum capacity required.
        return left;
    }

    // Helper function to determine if it's possible to ship all packages within 'days'
    // using a capacity of 'capacity'.
    private boolean canShip(int[] weights, int capacity, int days) {
        int count = 1; // Start with the first day
        int sum = 0;   // Current weight sum for the current day

        for (int w : weights) {
            sum += w; // Add the weight of the current package
            if (sum > capacity) {
                // If the current day's load exceeds capacity,
                // move to the next day and reset the sum to the current package.
                count++;
                sum = w;
            }
        }

        // If the required days exceed the allowed days, return true (capacity is insufficient).
        return count > days;
    }

}
