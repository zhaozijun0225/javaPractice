package leetcode;

import java.util.HashMap;

public class T146 {

    static class LRUCache {

        class delList {
            int key;
            delList next;

            delList() {
            }

            delList(int key, delList next) {
                this.key = key;
                this.next = next;
            }
        }

        delList dummyHead;
        int capacity;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        LRUCache(int capacity) {
            this.capacity = capacity;
            this.dummyHead = new delList(0,null);
        }

        public int get(int key) {
            return hm.getOrDefault(key,-1);
        }

        public void put(int key, int value) {

        }
    }


    public static void main(String[] args) {


    }
}
