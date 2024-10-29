package com.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
//    https://leetcode.com/problems/lru-cache/

    // Cache capacity
    private int capacity;

    // Cache storage to quickly access nodes by their key
    private Map<Integer, Node> cache;

    // Dummy head and tail nodes to maintain the order of nodes
    private Node head, tail;

    // Constructor to initialize the cache with given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Initialize dummy head and tail nodes
        // Head represents the least recently used (LRU) end
        // Tail represents the most recently used (MRU) end
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        // Link the dummy head and tail nodes
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    // Method to get the value associated with a key
    public int get(int key) {
        if (cache.containsKey(key)) {
            // If the key exists, move the node to the most recent position
            remove(cache.get(key));
            insert(cache.get(key));
            // Return the value of the node
            return cache.get(key).value;
        }
        // Return -1 if the key doesn't exist
        return -1;
    }

    // Method to put a key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key))
            // If the key already exists, remove the old node
            remove(cache.get(key));

        // Create a new node and put it into the cache
        cache.put(key, new Node(key, value));
        // Insert the new node at the most recent position
        insert(cache.get(key));

        // If the cache exceeds its capacity, remove the least recently used node
        if (cache.size() > capacity) {
            // The least recently used node is next to the dummy head
            Node lru = this.head.next;
            // Remove the LRU node from the list and the cache
            remove(lru);
            cache.remove(lru.key);
        }
    }

    // Method to insert a node at the most recent position
    public void insert(Node node) {
        // Get the current last node before the dummy tail
        Node prev = this.tail.prev;
        Node next = this.tail;

        // Link the new node between the last node and the dummy tail
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }

    // Method to remove a node from the doubly linked list
    public void remove(Node node) {
        // Get the previous and next nodes
        Node prev = node.prev;
        Node next = node.next;

        // Link the previous node to the next node, bypassing the current node
        prev.next = next;
        next.prev = prev;
    }

    // Inner class to represent each node in the doubly linked list
    private class Node {
        int key;   // Key of the node
        int value; // Value of the node
        Node prev; // Pointer to the previous node
        Node next; // Pointer to the next node

        // Constructor to initialize a node with a key-value pair
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

