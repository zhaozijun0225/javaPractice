package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T146 {

    private Map<Integer, LRULinkedCache> map = new HashMap<>();
    private int size;
    private int capacity;
    private LRULinkedCache head, tail;

    class LRULinkedCache {
        int key;
        int value;
        LRULinkedCache prev;
        LRULinkedCache next;

        public LRULinkedCache() {
            key = 0;
            value = 0;
            prev = null;
            next = null;
        }

        public LRULinkedCache(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LRULinkedCache();
        tail = new LRULinkedCache();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        boolean isInCache = map.containsKey(key);
        if (isInCache) {
            LRULinkedCache cache = map.get(key);
            moveToHead(cache);
            return cache.value;
        } else {
            return -1;
        }

    }

    public void put(int key, int value) {
        boolean isInCache = map.containsKey(key);
        LRULinkedCache cache = null;
        if (isInCache) {
            cache = map.get(key);
            moveToHead(cache);
        } else {
            cache = new LRULinkedCache(key, value);
            cache.next = head.next;
            cache.prev = head;
            head.next.prev = cache;
            head.next = cache;
            if (size == capacity) {
                LRULinkedCache toDel = tail.prev;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(toDel.key);
            } else {
                size++;
            }
            map.put(cache.key, cache);

        }
        cache.value = value;


    }

    private void moveToHead(LRULinkedCache cache) {
        cache.prev.next = cache.next;
        cache.next.prev = cache.prev;
        cache.next = head.next;
        cache.prev = head;
        head.next.prev = cache;
        head.next = cache;

    }


    public static void main(String[] args) {


    }
}
