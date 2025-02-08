package com.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {

//    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/


    // Time complexity: O(klogk), where k is the number of pairs we need to find.
    // We are adding k elements to the heap, and each time we poll an element from the heap, we add another element to the heap.
    // Space complexity: O(k), as we are using a heap to store the k smallest pairs.
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min-heap para armazenar os pares (soma, índice de nums1, índice de nums2)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]]))); // Ordena pelo valor da soma

        // Inicializa a heap com os primeiros elementos de nums1 combinados com nums2[0]
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // Processa os k menores pares
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] index = minHeap.poll();
            int i = index[0];
            int j = index[1];
            result.add(List.of(nums1[i], nums2[j]));

            // Adiciona o próximo par (i, j+1) se ainda houver elementos em nums2
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }

}
