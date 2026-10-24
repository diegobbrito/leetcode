package com.leetcode.string;

public class CircularSentence {

//    https://neetcode.io/problems/circular-sentence/question
//    Time Complexity O(n)
//    Memory Complexity O(n)
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int size = words.length;
        char first = words[0].charAt(0);
        char last = words[size - 1].charAt(words[size - 1].length() - 1);
        if(first != last){
            return false;
        }
        last = words[0].charAt(words[0].length() - 1);
        for(int i = 1; i < size; i++){
            first = words[i].charAt(0);
            if(first != last){
                return false;
            }
            last = words[i].charAt(words[i].length() - 1);
        }

        return true;
    }

//    Time Complexity O(n)
//    Memory Complexity O(1)
    public boolean isCircularSentenceOptimize(String sentence) {
        int size = sentence.length();

        if(sentence.charAt(0) != sentence.charAt(size - 1)){
            return false;
        }
        for(int i = 1; i < size - 1; i++){
            if(sentence.charAt(i) == ' '){
                if(sentence.charAt(i - 1) != sentence.charAt(i + 1))
                    return false;
            }
        }

        return true;
    }
}
