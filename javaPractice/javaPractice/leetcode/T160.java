package leetcode;

/**
 * @Author: zijun.zhao
 * @Date: 2026/6/13 上午4:26
 */

public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
