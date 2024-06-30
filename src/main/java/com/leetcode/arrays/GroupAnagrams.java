package com.leetcode.arrays;

import java.util.*;


public class GroupAnagrams {
    //    https://leetcode.com/problems/group-anagrams/
    public static void main(String[] args) {
        var response = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(response);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to add as key the sorted characters
        // and as value a List, then adding the values in this list
        // finally returning the list of lists with the group of anagrams
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
