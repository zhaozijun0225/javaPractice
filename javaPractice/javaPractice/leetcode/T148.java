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


        ListNode Node1 = head, Node2, Node3, rNode = new ListNode(1), endNode;
        int maxVal, sortLen = 1, totalLen = 0, cnt = 0;
        while (Node1 != null) {
            totalLen++;
            Node1 = Node1.next;
        }

        Node1 = new ListNode(1);
        while (sortLen < totalLen) {
            Node1.next = head;

            while (Node1 != null && Node1.next != null) {

                Node2 = Node1;
                for (cnt = 0; cnt < sortLen; cnt++) {
                    Node2 = Node2.next;
                    if (Node2.next == null)
                        break;
                }
                if (cnt != sortLen) {
                    Node1 = Node2;
                    break;
                }
                Node3 = Node2;
                for (cnt = 0; cnt < sortLen; cnt++) {
                    Node3 = Node3.next;
                    if (Node3.next == null)
                        break;
                }

                Node3 = Node3.next;
                mergeHead(Node1, Node2, rNode, Node3);
                Node1.next = rNode

                Node1 = Node3;
            }


            sortLen *= 2;
        }


    }


    static void mergeHead(ListNode head1, ListNode head2, ListNode rNode, ListNode Node3) {

        ListNode tmpNode1 = head1,tmpNode2 = head2;
        while (head1.next != null && head2.next != null && tmpNode1 != head2 && tmpNode2.next != Node3) {
            if (head1.next.val < head2.next.val) {
                rNode.next = head1.next;
                head1 = head1.next;
            } else {
                rNode.next = head2.next;
                head2 = head2.next;
            }
            rNode = rNode.next;
        }

        if (head1.next == null || tmpNode1==head2) {
            rNode.next = head2.next;
        } else {
            rNode.next = head1.next;
        }
        while(rNode.next!= null){
            rNode = rNode.next;
        }


    }


}
