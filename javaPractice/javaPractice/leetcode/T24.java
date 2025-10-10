package leetcode;

public class T24 {

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmpNode = head;
        for (int i = 2; i < 5; i++) {
            tmpNode.next = new ListNode(i);
            tmpNode = tmpNode.next;
        }

        ListNode ansHead = new ListNode(0, head), tmpNode1 = ansHead, tmpNode2, tmpNode3;

        while (tmpNode1 != null && tmpNode1.next != null && tmpNode1.next.next != null) {
            tmpNode2 = tmpNode1.next;

            tmpNode1.next = tmpNode2.next;
            tmpNode2.next = tmpNode1.next.next;
            tmpNode1.next.next = tmpNode2;





            tmpNode1 = tmpNode1.next.next;
        }

//        System.out.println(ansHead.next);
        return ansHead.next;

    }


}
