package leetcode;

import java.util.*;

public class T236 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static TreeNode ans = null;

    static boolean search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean l = search(root.left, p, q);
        boolean r = search(root.right, p, q);

        if ((l && r) || (((root.val == p.val) || (root.val == q.val)) && (l || r))) {
            ans = root;
            return false;
        }


        return l || r || root.val == p.val || root.val == q.val;


    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1), p = new TreeNode(1), q = new TreeNode(1);


        ans = null;
        search(root, p, q);

        return ans;


    }


}
