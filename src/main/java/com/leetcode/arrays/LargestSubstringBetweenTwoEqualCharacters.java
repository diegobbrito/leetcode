package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {
    //    https://leetcode.com/problems/largest-substring-between-two-equal-characters
//    Two pass solution
//    Time complexity: O(n)
//    Space complexity: O(1) since we have at most 26 different characters.
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            var list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        int result = -1;
        for (List<Integer> l : map.values()) {
            if (l.size() > 1) {
                int min = l.get(0);
                int max = l.get(l.size() - 1) - 1;
                result = Math.max(result, max - min);
            }
        }
        return result;
    }

    // One pass solution
    //    Time complexity: O(n)
    //    Space complexity: O(1) since we have at most 26 different characters.

    public int maxLengthBetweenEqualCharactersOptimize(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                result = Math.max(result, i - map.get(c));
            else
                map.put(c, i + 1);
        }
        return result;
    }

    //    Time complexity: O(n)
    //    Space complexity: O(1) since we have at most 26 different characters.
    public int maxLengthBetweenEqualCharactersOptimizeWithArray(String s) {
        int result = -1;
        int[] arr = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            int idx = s.charAt(i) - 'a'; // 'a' - 'a' = 0, 'b' - 'a' = 1
            if (arr[idx] == 0) // 0 means not visited
                arr[idx] = i + 1; // add index + 1
            else
                result = Math.max(result, i - arr[idx]); // calculate the difference between current index and previous index
        }
        return result;
    }
}
