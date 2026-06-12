package leetcode;

/**
 * @Author: zijun.zhao
 * @Date: 2026/6/13 上午4:36
 */

public class T206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev, curr;
        prev = null;
        curr = head;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }


        return prev;

    }
}
