package com.leetcode.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {
//    https://www.hackerrank.com/challenges/sock-merchant/problem

    // Time: O(n), Space: O(n)
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : ar) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int pairs = 0;
        for (Integer v : map.values()) {
            pairs += v / 2;
        }
        return pairs;
    }

    // Time: O(n), Space: O(1)
    public int sockMerchant(int n, int[] ar) {
        int[] arr = new int[101];
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            arr[ar[i]]++;
        }

        for (int j : arr) {
            pairs += j / 2;
        }

        return pairs;
    }
}
