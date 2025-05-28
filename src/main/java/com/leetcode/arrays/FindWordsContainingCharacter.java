package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    //    https://leetcode.com/problems/find-words-containing-character/
    //    Time Complexity: O(n * m)
    //    Space Complexity: O(1)

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        String s = String.valueOf(x);
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(s)) {
                result.add(i);
            }
        }
        return result;
    }
}
