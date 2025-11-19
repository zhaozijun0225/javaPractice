package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

public class T199 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4),t2 = new TreeNode(5),t3= new TreeNode(3,null,t1),t4= new TreeNode(2,null,t2),root = new TreeNode(1,t4,t3);


        TreeNode treeNodeTmp1, treeNodeTmp2;
        int count = 0, intTmp1;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<Integer> ans = new ArrayList(10);

        if (root == null)
//            return ans;
            return;

        queue.offer(root);
        count++;


        while (!queue.isEmpty()) {
            intTmp1 = count;
            count = 0;
            treeNodeTmp2 = null;
            for (; intTmp1 > 0; intTmp1--) {
                treeNodeTmp1 = queue.poll();
                treeNodeTmp2 = treeNodeTmp1;
                if (treeNodeTmp1.left != null) {
                    queue.offer(treeNodeTmp1.left);
                    count++;
                }
                if (treeNodeTmp1.right != null) {
                    queue.offer(treeNodeTmp1.right);
                    count++;
                }
            }
            if (treeNodeTmp2 != null)
                ans.add(treeNodeTmp2.val);

        }
//        return ans;
        return;

    }
}
