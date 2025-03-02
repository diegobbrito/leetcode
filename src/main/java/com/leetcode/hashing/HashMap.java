package com.leetcode.hashing;

public class HashMap {

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] map;

    public HashMap() {
        map = new Node[1000];
    }

    private int hash(int key) {
        return key % map.length;
    }

    public void put(int key, int value) {
        var hash = hash(key);
        if (map[hash] == null) {
            map[hash] = new Node(key, value);
        } else {
            var cur = map[hash];
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                if (cur.next == null) {
                    cur.next = new Node(key, value);
                    return;
                }
                cur = cur.next;
            }
        }
    }

    public int get(int key) {
        var hash = hash(key);
        var cur = map[hash];
        while (cur != null) {
            if (cur.key == key)
                return cur.value;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        var hash = hash(key);
        if (map[hash] == null) {
            return;
        }

        var cur = map[hash];
        if (cur.key == key) {
            map[hash] = cur.next;
            return;
        }

        var prev = cur;
        cur = cur.next;
        while (cur != null) {
            if (cur.key == key) {
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}