package com.neetcode150.linkedlist;

import java.util.HashMap;

class LRUNode {
    int key;
    int val;
    LRUNode next;
    LRUNode prev;

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    private int capacity;
    private HashMap<Integer,LRUNode> cache;
    private LRUNode left;
    private LRUNode right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new LRUNode(0, 0);
        this.right = new LRUNode(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(LRUNode node) {
        LRUNode prev = node.prev;
        LRUNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(LRUNode node) {
        LRUNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LRUNode node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }

        LRUNode node = new LRUNode(key, value);
        cache.put(key,node);
        insert(node);

        if (cache.size() > capacity) {
            LRUNode newNode = this.left.prev;
            remove(newNode);
            cache.remove(newNode.key);
        }
    }
}
