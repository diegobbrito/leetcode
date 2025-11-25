package com.leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

//    https://leetcode.com/problems/binary-prefix-divisible-by-5/
//    Time Complexity O(n)
//    Space Complexity O(1)

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            answer.add(prefix == 0);
        }
        return answer;
    }
}
