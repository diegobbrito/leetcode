package com.leetcode.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
//    https://leetcode.com/problems/time-based-key-value-store/

    //      Time complexity:
//  set(): O(1) (amortized).
//  get(): O(logn), where n is the number of timestamped entries for the key.
//      Memory complexity: O(k×ni×m)
//  where k is the number of keys, 𝑛 is the number of timestamps for key i, and m is the average string length.
    class TimeMap {

        // A map to store a list of (value, timestamp) pairs for each key
        Map<String, List<Pair<String, Integer>>> map;

        // Constructor to initialize the map
        public TimeMap() {
            map = new HashMap<>();
        }

        // Method to set a key-value pair with a specific timestamp
        public void set(String key, String value, int timestamp) {
            // If the key is not in the map, create a new list for it
            map.putIfAbsent(key, new ArrayList<>());
            // Add the (value, timestamp) pair to the list associated with the key
            map.get(key).add(new Pair<>(value, timestamp));
        }

        // Method to get the value associated with the key at the given timestamp
        public String get(String key, int timestamp) {
            // If the key does not exist, return an empty string
            if (!map.containsKey(key)) return "";
            // Get the list of pairs (value, timestamp) for the key
            List<Pair<String, Integer>> list = map.get(key);
            // Perform a binary search to find the value corresponding to the closest timestamp ≤ given timestamp
            return binarySearch(list, timestamp);
        }

        // Helper method to perform binary search on the list of (value, timestamp) pairs
        private String binarySearch(List<Pair<String, Integer>> list, int timestamp) {
            int left = 0, right = list.size() - 1;
            String response = "";

            // Standard binary search loop
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Pair<String, Integer> pair = list.get(mid);
                var currTimestamp = pair.value;  // Get the timestamp of the current mid element

                // If the current timestamp is less than the given one, move right
                if (currTimestamp < timestamp) {
                    left = mid + 1;
                    response = pair.key;  // Keep track of the closest value
                }
                // If the current timestamp is greater than the given one, move left
                else if (currTimestamp > timestamp) {
                    right = mid - 1;
                }
                // If the timestamp matches exactly, return the value
                else {
                    return pair.key;
                }
            }
            // Return the closest value found or empty string if no valid timestamp exists
            return response;
        }

        // A simple Pair class to store a key-value pair (used for value and timestamp)
        static class Pair<K, V> {
            K key;
            V value;

            // Constructor to initialize the pair with key and value
            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }

}
