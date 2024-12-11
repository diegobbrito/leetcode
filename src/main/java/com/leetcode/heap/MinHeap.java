package com.leetcode.heap;

import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        MinHeap solution = new MinHeap();
        solution.insert(4);
        solution.insert(2);
        solution.insert(1);
        solution.insert(3);
        solution.insert(5);
        solution.insert(4);
        System.out.println(solution.poll());
        System.out.println(solution.poll());
    }

    private int size;
    private int[] heap;

    public MinHeap() {
        size = 1;
        heap = new int[10];
    }

    //    Time Complexity O(logn)
    private void insert(int val) {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = val;
        heapifyUp(size);
        size++;
    }

    //    Time Complexity O(logn)
    private int poll() {
        if (size == 1) return -1;

        int min = heap[1];
        size--;
        if (size == 1) {
            heap = new int[10];
            return min;
        }
        heap[1] = heap[size];
        heapifyDown(1);
        return min;
    }


    private void heapifyDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        if (index >= size || leftIndex > size) return;

        int leftValue = heap[leftIndex];
        int rightValue = heap[rightIndex];
        int value = heap[index];
        if (leftValue > rightValue && value > rightValue) {
            heap[index] = rightValue;
            heap[rightIndex] = value;
            heapifyDown(rightIndex);
        } else if (rightValue > leftValue && value > leftValue) {
            heap[index] = leftValue;
            heap[leftIndex] = value;
            heapifyDown(leftIndex);
        }
    }

    private void heapifyUp(int index) {
        if (index == 1) return;

        int parent = parent(index);
        int parentVal = heap[parent];
        int value = heap[index];
        if (parentVal > value) {
            heap[index] = parentVal;
            heap[parent] = value;
            heapifyUp(parent);
        }
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }
}
