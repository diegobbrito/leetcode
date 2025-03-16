package com.leetcode.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    //    https://www.hackerrank.com/challenges/count-triplets-1/problem
//Brute force approach
//    Time complexity: O(n^3), Space complexity: O(1)
    static long countTriplets(List<Long> arr, long r) {
        int result = 0;
        for (int i = 0; i < arr.size() - 2; i++) {
            long a = arr.get(i);
            for (int j = i + 1; j < arr.size() - 1; j++) {
                long b = arr.get(j);
                for (int k = j + 1; k < arr.size(); k++) {
                    long c = arr.get(k);
                    if (a * r == b && b * r == c)
                        result++;
                }
            }
        }
        return result;
    }

    //Optimized approach
//    Time complexity: O(n), Space complexity: O(n)
    static long countTripletsOptimize(List<Long> arr, long r) {
        Map<Long, Long> potentialPairs = new HashMap<>();
        Map<Long, Long> potentialTriplets = new HashMap<>();
        long count = 0;

        for (long value : arr) {
            // If value completes a triplet, add the count of such triplets
            count += potentialTriplets.getOrDefault(value, 0L);

            // If value can be the second element of a triplet, update potential triplets
            if (potentialPairs.containsKey(value)) {
                potentialTriplets.put(value * r, potentialTriplets.getOrDefault(value * r, 0L) + potentialPairs.get(value));
            }

            // Every value can be the start of a new triplet
            potentialPairs.put(value * r, potentialPairs.getOrDefault(value * r, 0L) + 1);
        }

        return count;
    }

}
