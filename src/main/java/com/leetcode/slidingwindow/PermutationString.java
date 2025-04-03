package com.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        Map<Character, Integer> mapA = new HashMap<>();
        for (char c : s1.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> mapB = new HashMap<>();
        int right = s1.length() - 1;

        for (int i = 0; i < right; i++) {
            mapB.put(s2.charAt(i), mapB.getOrDefault(s2.charAt(i), 0) + 1);
        }


        for (int left = 0; right < s2.length(); right++, left++) {
            mapB.put(s2.charAt(right), mapB.getOrDefault(s2.charAt(right), 0) + 1);

            if (mapA.equals(mapB)) {
                return true;
            }

            char removeChar = s2.charAt(left);
            mapB.put(removeChar, mapB.getOrDefault(removeChar, 0) - 1);
            if (mapB.get(removeChar) == 0) {
                mapB.remove(removeChar);
            }
        }

        return mapA.equals(mapB);
    }

    public static void main(String[] args) {
        PermutationString obj = new PermutationString();
        System.out.println(obj.checkInclusion("adc", "dcda"));
        System.out.println(obj.checkInclusion("ab", "eidboaoo"));
    }
}
