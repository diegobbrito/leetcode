package com.leetcode.heap;

import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    public static void main(String[] args) {
        var test = kClosest(new int[][]{{1, 3}, {-2, 2}, {2, -2}}, 2);
        System.out.println(test[0][0]);
    }

    //First solution Time Complexity is O(NlogN)
    public static int[][] kClosest(int[][] points, int k) {
        //Use a min heap and add the values using the formula and return the top k values
        //We can completely ignore the square root as we are just comparing the values (if a*a>b*b => a>b)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->
                Integer.compare(
                        (a[0] * a[0] + a[1] * a[1]),
                        (b[0] * b[0] + b[1] * b[1])
                )
        );

        for (int[] point : points)
            heap.offer(point);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] temp = heap.poll();
            result[i][0] = temp[0];
            result[i][1] = temp[1];
        }
        return result;
    }

    //This approach is a sightly optimized approach here we can use a max heap and maintain its size as k.
    //So when we do the removal the time complexity will reduce from logn to logk
    //Max heap because we will remove the top elements (the one which are greater)
    //Overall Time complexity O(NlogK)

    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->
                Integer.compare(
                        (b[0] * b[0] + b[1] * b[1]),
                        (a[0] * a[0] + a[1] * a[1])
                )
        ); //only this is changed (swapped)
        for (int[] point : points) {
            heap.offer(point);
            //remove when size increase k
            if (heap.size() > k)
                heap.poll();
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = heap.poll();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }

}
