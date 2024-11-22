package com.leetcode.bitmanipulation;

public class FindDifference {
    //https://leetcode.com/problems/find-the-difference/
    // Map Solution
    //Time Complexity O (n+m)
    //Memory Complexity O(1) - Map with max of 26 keys

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)  + 1);
        
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)  - 1);
        
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            if(entry.getValue() != 0)
                return entry.getKey();

        return ' ';
    }
    // ASCII Solution
    //Time Complexity O (n+m)
    //Memory Complexity O(1)
    public char findTheDifferenceASCII(String s, String t) {
        int sum = 0;
        for(char c : t.toCharArray())
            sum += c;
        for(char c : s.toCharArray())
            sum -= c;

        return (char) sum;
    }

    //  Bit Manipulation Solution
    // XOR each element in the first string, then XOR each element in the second string, it will only rest the diffent element
    // When and element is XOR with itself the response is zero  7 ^ 7 = 0
    // Zero XOR any number is equal to the number 7 ^ 0 = 7
    //  Time Complexity O (n+m)
    //  Memory Complexity O(1)
    public char findTheDifferenceBit(String s, String t) {
        int result = 0;
        for(char c : s.toCharArray())
            result ^= c;
        for(char c : t.toCharArray())
            result ^= c;

        return (char) result;
    }

}