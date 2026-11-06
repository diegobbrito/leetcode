package com.leetcode.sorting;

public class CustomSortString {
//    https://neetcode.io/problems/custom-sort-string/
//    Time Complexity O(n + m) where n is the length of the order string and m is the length of the s string
//    Memory Complexity O(1) since the size of the chars array is constant (26)

    public String customSortString(String order, String s) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            chars[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for(char c : order.toCharArray()){
            while(chars[c - 'a'] > 0){
                sb.append(c);
                chars[c - 'a']--;
            }
        }
        for(int i = 0; i < 26; i++){
            while(chars[i] > 0){
                sb.append((char)(i + 'a'));
                chars[i]--;
            }
        }

        return sb.toString();
    }
}
