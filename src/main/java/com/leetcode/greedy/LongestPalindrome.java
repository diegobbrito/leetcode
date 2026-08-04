package com.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

//    https://leetcode.com/problems/longest-palindrome/
//    Time Complexity O(n)
//    Space Complexity O(n)

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int sum = 0;
        boolean odd = false;

        for(int count : map.values()){
            if(count % 2 == 0){
                sum += count;
            } else {
                odd = true;
                sum += count - 1;
            }
        }
        if(odd) sum++;

        return sum;
    }

}
