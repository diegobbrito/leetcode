package com.leetcode.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    //https://leetcode.com/problems/sliding-window-maximum/
    //Time complexity: O(nlogk)
    //Space complexity: O(k)

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] response = new int[nums.length - k + 1];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int right = 0;
        while (right < k - 1) {
            maxHeap.offer(nums[right++]);
        }

        for (int left = 0, i = 0; right < nums.length; i++, left++, right++) {
            maxHeap.offer(nums[right]);
            response[i] = maxHeap.peek();
            maxHeap.remove(nums[left]);
        }

        return response;
    }

    //Time complexity: O(nlogk)
    //Space complexity: O(k)
    public int[] maxSlidingWindow2(int[] nums, int k) {

        int[] response = new int[nums.length - k + 1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int right = 0;
        while (right < k - 1) {
            maxHeap.offer(new int[]{nums[right], right});
            right++;
        }

        for (int left = 0, i = 0; right < nums.length; i++, left++, right++) {
            maxHeap.offer(new int[]{nums[right], right});
            int[] max = maxHeap.peek();
            while (max[1] < left) {
                maxHeap.poll();
                max = maxHeap.peek();
            }
            response[i] = max[0];
        }

        return response;
    }

    //Time complexity: O(nlogk)
    //Space complexity: O(k)

    public int[] maxSlidingWindow3(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }
                output[idx++] = heap.peek()[0];
            }
        }
        return output;
    }

    //Time complexity: O(n)
    //Space complexity: O(n)

    public int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>(); // Guarda índices, não valores

        while (r < n) {
            // 1️⃣ Remove do final da deque todos os índices com valores menores que o atual
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            // 2️⃣ Adiciona o índice atual ao final da deque
            q.addLast(r);

            // 3️⃣ Remove o índice da esquerda se ele saiu da janela
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // 4️⃣ Se a janela estiver completa (r - l + 1 == k), salva o máximo
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++; // Move a janela para frente
            }

            r++; // Avança a janela à direita
        }

        return output;
    }

}
