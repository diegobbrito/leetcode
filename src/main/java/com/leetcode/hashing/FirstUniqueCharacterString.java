package com.leetcode.hashing;

public class FirstUniqueCharacterString {

//    https://neetcode.io/problems/first-unique-character-in-a-string/
//    Time Complexity O(n)
//    Space Complexity O(1)
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
