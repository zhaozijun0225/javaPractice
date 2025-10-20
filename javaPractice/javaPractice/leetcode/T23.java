package leetcode;

import java.util.*;

public class T23 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static private class p {
        int val;
        int idx;

        p() {
        }

        p(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        lists[2] = new ListNode(2, new ListNode(6, null));


        ListNode ans = new ListNode(0, null);
        if (lists.length == 0) {
            return ans.next;
        }
        PriorityQueue sq = new PriorityQueue<p>(new Comparator<p>() {
            @Override
            public int compare(p o1, p o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                sq.add(new p(lists[i].val, i));
                lists[i] = lists[i].next;
            }
            }


            p tmpP1;
            ListNode tmpAns = ans;
            while (!sq.isEmpty()) {
                tmpP1 = (p) sq.poll();
                tmpAns.next = new ListNode(tmpP1.val, null);
                tmpAns = tmpAns.next;
                if (lists[tmpP1.idx] != null) {
                    sq.add(new p(lists[tmpP1.idx].val, tmpP1.idx));
                    lists[tmpP1.idx] = lists[tmpP1.idx].next;
                }


            }
            return ans.next;

        }
    }
