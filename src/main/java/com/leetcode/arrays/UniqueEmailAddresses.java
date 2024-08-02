package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    //    https://leetcode.com/problems/unique-email-addresses/
//    Time Complexity O(n)
//    Memory Complexity O(n)
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            set.add(split[0].split("\\+")[0].replace(".", "") + "@" + split[1]);
        }
        return set.size();
    }
}
