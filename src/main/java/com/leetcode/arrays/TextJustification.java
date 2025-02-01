package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    //https://leetcode.com/problems/text-justification/
    // Time complexity: O(n)
    // Space complexity: O(n)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int length = 0;
        int i = 0;

        while (i < words.length) {
            if (length + line.size() + words[i].length() > maxWidth) {
                int extraSpace = maxWidth - length;
                int spaces = extraSpace / Math.max(1, line.size() - 1);
                int remainder = extraSpace % Math.max(1, line.size() - 1);
                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {
                    String word = line.get(j).concat(" ".repeat(spaces));
                    if (remainder > 0) {
                        word += " ";
                        remainder--;
                    }
                    line.set(j, word);
                }
                result.add(String.join("", line));
                line = new ArrayList<>();
                length = 0;
            }
            line.add(words[i]);
            length += words[i].length();
            i++;
        }

        if (!line.isEmpty()) {
            String lastLine = String.join(" ", line);
            int remainingSpace = maxWidth - lastLine.length();
            result.add(lastLine + " ".repeat(remainingSpace));
        }

        return result;
    }
}
