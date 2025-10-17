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
        int[] tmp = {-1, 5, 3, 4, 0};
        for (int i = 0; i < 5; i++) {
            tmpHead.next = new ListNode(tmp[i]);
            tmpHead = tmpHead.next;
        }
        head = head.next;

        if (head == null)
//            return head;
            return;


        ListNode Node1 = head, Node2, Node3, endNode, curr, merged, prev;
        int maxVal, sortLen = 1, totalLen = 0, cnt = 0;
        while (Node1 != null) {
            totalLen++;
            Node1 = Node1.next;
        }

        Node1 = new ListNode(1);
        Node1.next = head;
        for (sortLen = 1; sortLen < totalLen; sortLen <<= 1) {
            curr = Node1.next;
            prev = Node1;
            while (curr != null) {

                Node2 = curr;
                for (cnt = 1; cnt < sortLen && curr.next != null; cnt++) {
                    curr = curr.next;
                }
                if (cnt != sortLen){
                    prev.next = Node2;
                    break;
                }


                Node3 = curr.next;
                curr.next = null;
                curr = Node3;

                for (cnt = 1; cnt < sortLen && curr != null && curr.next != null; cnt++) {
                    curr = curr.next;
                }
                endNode = null;
                if (curr != null) {
                    endNode = curr.next;
                    curr.next = null;
                }

                merged = mergeHead(Node2, Node3);
                prev.next = merged;
                while (prev.next != null)
                    prev = prev.next;

                curr = endNode;
            }

        }

//        return Node1.next;
        return;
    }


    static ListNode mergeHead(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(1), tmp1 = head1, tmp2 = head2,tmp = dummyHead;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        if(tmp1 == null){
            tmp.next = tmp2;
        }
        else{
            tmp.next = tmp1;
        }

    return dummyHead.next;
    }


}


//另一个奇葩写法
//看样子是桶排
//class Solution {
//    public ListNode sortList(ListNode head) {
//        int len=0;
//        ListNode cur=head;
//        int min=Integer.MAX_VALUE;
//        int max=Integer.MIN_VALUE;
//        while(cur!=null){
//            min=Math.min(min,cur.val);
//            max=Math.max(max,cur.val);
//            cur=cur.next;
//            len++;
//        }
//        int[]memo=new int[max-min+1];
//        cur=head;
//        while(cur!=null){
//            memo[cur.val-min]++;
//            cur=cur.next;
//
//        }
//        cur=head;
//        int i=0;
//        while(cur!=null){
//            while(memo[i]==0){
//                i++;
//            }
//            cur.val=i+min;
//            memo[i]--;
//            cur=cur.next;
//        }
//        return head;
//
//    }
//}