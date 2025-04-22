package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomsII {

    // https://leetcode.com/problems/meeting-rooms-ii/
    // Time complexity: O(n log n)
    // Space complexity: O(n)
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> time = new ArrayList<>();
        for (Interval i : intervals) {
            time.add(new int[]{i.start, 1});
            time.add(new int[]{i.end, -1});
        }

        time.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int res = 0, count = 0;
        for (int[] t : time) {
            count += t[1];
            res = Math.max(res, count);
        }
        return res;
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
