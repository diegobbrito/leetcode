package com.leetcode.arrays;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DestinationCity {
    //	https://leetcode.com/problems/destination-city/
    //	Time Complexity O(n)
    //	Memory Complexity O(n)
    public String destCity(List<List<String>> paths) {
        Set<String> cities = paths.stream().map(path -> path.get(0)).collect(Collectors.toSet());

        for (List<String> path : paths) {
            if (!cities.contains(path.get(1)))
                return path.get(1);
        }
        return "";
    }
}

