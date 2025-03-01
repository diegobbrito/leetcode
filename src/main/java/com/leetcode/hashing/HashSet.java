package com.leetcode.hashing;

public class HashSet {

    private Node[] nodes;

    public HashSet() {
        nodes = new Node[10000];
    }

    public void add(int key) {
        var cur = nodes[key % nodes.length];
        if (cur == null) {
            nodes[key % nodes.length] = new Node(key);
            return;
        }
        while (cur.next != null) {
            if (cur.key == key) return;
            cur = cur.next;
        }
        if (cur.key == key) return;
        cur.next = new Node(key);
    }

    public void remove(int key) {
        var cur = nodes[key % nodes.length];
        if (cur == null) return;
        if (cur.key == key) {
            nodes[key % nodes.length] = cur.next;
            return;
        }
        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }

    }

    public boolean contains(int key) {
        var cur = nodes[key % nodes.length];
        while (cur != null) {
            if (cur.key == key) return true;
            cur = cur.next;
        }
        return false;

    }

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }
}
