package com.leetcode.arrays;

import java.util.*;

public class InsertDeleteGetRandom {

    //    https://leetcode.com/problems/insert-delete-getrandom-o1/
    //Time complexity: O(1) for each function call.
    //Space complexity: O(n)

    class RandomizedSet {

        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random;
        private int size;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
            size = 0;
        }

        // Check if the value is already present in the map. If it is present, return false.
        // Otherwise, add the value to the map and list.
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, size++); // Map the value to the index of the list.
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) { // Check if the value is present in the map. If it is not present, return false.
                return false;
            }
            int index = map.get(val); // Otherwise, get the index of the value from the map.
            int lastElement = list.get(size - 1); // Get the last element from the list and set it at the index of the value.
            list.set(index, lastElement);
            map.put(lastElement, index);
            list.remove(--size); // Remove the last element from the list.
            map.remove(val);        // Remove the value from the map.
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(size));
        }
    }

}
