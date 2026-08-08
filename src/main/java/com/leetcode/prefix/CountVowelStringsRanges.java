package com.leetcode.prefix;

public class CountVowelStringsRanges {

//    https://leetcode.com/problems/count-vowel-strings-in-ranges/
//    Time Complexity O(n + m), where n is the length of words and m is
//    the length of queries
//    Space Complexity O(n)

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        int sum = 0;

        for(int i = 0; i < words.length; i++){
            if(isValid(words[i])){
                sum++;
            }
            prefix[i] = sum;
        }
        int[] result = new int[queries.length];

        for(int r = 0; r < queries.length; r++){
            int start = queries[r][0];
            int end = queries[r][1];

            if(start > 0){
                result[r] = prefix[end] - prefix[start - 1];
            } else {
                result[r] = prefix[end];
            }
        }

        return result;

    }

    private boolean isValid(String word){
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        char last = word.charAt(word.length() - 1);
        boolean firstVowel = false;
        boolean lastVowel = false;

        for(char vowel : vowels){
            if(word.charAt(0) == vowel){
                firstVowel = true;
            }
            if(last == vowel){
                lastVowel = true;
            }
        }

        return firstVowel && lastVowel;
    }
}
