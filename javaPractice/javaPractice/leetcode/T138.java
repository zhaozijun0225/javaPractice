package leetcode;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class T138 {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);

        Node newhead = new Node(1), tmpNode1 = newhead,tmpNode2 = head;
        Map rem = new HashMap<Integer, Node>();

        while (tmpNode2 != null) {
            tmpNode1.next = new Node(tmpNode2.val);
            rem.put(tmpNode2.hashCode(), tmpNode1.next);
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;

        }

        tmpNode1 = newhead;tmpNode2 = head;
        while(tmpNode2 != null){
            if(tmpNode2.random == null){
                tmpNode1.next.random = null;
            }
            else{
                tmpNode1.next.random = (Node) rem.get(tmpNode2.random.hashCode());
            }
            tmpNode2 = tmpNode2.next;
            tmpNode1 = tmpNode1.next;


        }

        return newhead.next;

    }


//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//
//        // 复制每个节点，把新节点直接插到原节点的后面
//        for (Node cur = head; cur != null; cur = cur.next.next) {
//            cur.next = new Node(cur.val, cur.next);
//        }
//
//        // 遍历交错链表中的原链表节点
//        for (Node cur = head; cur != null; cur = cur.next.next) {
//            if (cur.random != null) {
//                // 要复制的 random 是 cur.random 的下一个节点
//                cur.next.random = cur.random.next;
//            }
//        }
//
//        // 把交错链表分离成两个链表
//        Node newHead = head.next;
//        Node cur = head;
//        for (; cur.next.next != null; cur = cur.next) {
//            Node copy = cur.next;
//            cur.next = copy.next; // 恢复原节点的 next
//            copy.next = copy.next.next; // 设置新节点的 next
//        }
//        cur.next = null; // 恢复原节点的 next
//        return newHead;
//    }
//
//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2993775/bu-yong-ha-xi-biao-de-zuo-fa-pythonjavac-nzdo/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
