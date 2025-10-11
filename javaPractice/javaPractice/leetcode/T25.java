package leetcode;

public class T25 {

    static class ListNode {
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


    static boolean nextCheck(ListNode head, int k) {
        for (int i = 0; i <= k; i++) {
            if (head == null)
                return false;
            head = head.next;
        }
        return true;
    }

    static void reverseNode(ListNode head, int k) {
        ListNode newHead = new ListNode(1, null), firstNode = head, tmpNode1;
        head = head.next;
        for (int i = 0; i < k; i++) {
            tmpNode1 = head;
            head = head.next;

            tmpNode1.next = newHead.next;
            newHead.next = tmpNode1;

        }

        firstNode.next.next = head;
        firstNode.next = newHead.next;

    }

    static ListNode iterNode(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null)
                return head;
            head = head.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmpNode = head;
        for (int i = 2; i < 6; i++) {
            tmpNode.next = new ListNode(i);
            tmpNode = tmpNode.next;
        }
        int k = 3;

        ListNode ansHead = new ListNode(0, head), tmpNode1 = ansHead;

        while (nextCheck(tmpNode1, k)) {
            reverseNode(tmpNode1, k);

            tmpNode1 = iterNode(tmpNode1, k);
        }

        System.out.println(ansHead.next);
//        return ansHead.next;

    }


}
