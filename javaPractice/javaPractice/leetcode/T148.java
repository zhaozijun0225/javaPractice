package leetcode;

import java.util.List;

public class T148 {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1), tmpHead = head;
        int[] tmp = {4, 2, 1, 3};
        for (int i = 0; i < 4; i++) {
            head.next = new ListNode(tmp[i]);
        }
        head = tmpHead.next;


        ListNode Node1 = head, Node2, Node3,maxNode;
        int maxVal,sortLen = 1,totalLen = 0;
        while(Node1 != null){
            totalLen++;
            Node1 = Node1.next;
        }


        while(sortLen<=)








    }
}
