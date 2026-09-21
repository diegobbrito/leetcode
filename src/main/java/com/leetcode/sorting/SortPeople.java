package com.leetcode.sorting;

import java.util.*;

public class SortPeople {

//    https://neetcode.io/problems/sort-the-people/
//    Time Complexity O(nlogn)
//    Space Complexity O(n)

    public String[] sortPeople(String[] names, int[] heights) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < names.length; i++){
            list.add(new int[]{heights[i], i});
        }

        list.sort((a, b) -> b[0] - a[0]);

        String[] result = new String[names.length];
        for(int i = 0; i < names.length; i++){
            result[i] = names[list.get(i)[1]];
        }

        return result;
    }

//    Time Complexity O(nlogn)
//    Space Complexity O(n)

    public String[] sortPeople2(String[] names, int[] heights) {
        Map<Integer, String> people = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            people.put(heights[i], names[i]);
        }
        Arrays.sort(heights);

        for (int i = 0, j = heights.length - 1; i < heights.length; i++, j--) {
            names[i] = people.get(heights[j]);
        }

        return names;
    }
}
