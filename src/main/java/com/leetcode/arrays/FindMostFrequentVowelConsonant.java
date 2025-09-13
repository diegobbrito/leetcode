package com.leetcode.arrays;

public class FindMostFrequentVowelConsonant {
//    https://leetcode.com/problems/find-most-frequent-vowel-and-consonant
//    Time complexity: O(n)
//    Space complexity: O(1)
    public int maxFreqSum(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        int vowel = 0;
        int consonant = 0;

        for(char c : "aeiou".toCharArray()){
            vowel = Math.max(vowel, count[c - 'a']);
        }
        for(char c : "bcdfghjklmnpqrstvwxyz".toCharArray()){
            consonant = Math.max(consonant, count[c - 'a']);
        }
        return vowel + consonant;
    }
}
