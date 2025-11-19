package leetcode;

import java.util.*;

public class T114 {
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
        TreeNode root = new TreeNode(1);


        if (root == null) {
            return;
        }

        TreeNode tnTmp1 = root;
        Deque<TreeNode> st = new ArrayDeque<TreeNode>();
        List<TreeNode> ans = new ArrayList<TreeNode>();

        st.push(tnTmp1);
        while (!st.isEmpty()) {
            tnTmp1 = st.pop();
            ans.add(tnTmp1);
            if (tnTmp1.right != null)
                st.push(tnTmp1.right);
            if (tnTmp1.left != null)
                st.push(tnTmp1.left);
        }

        tnTmp1 = root;
        for (int i = 1; i < ans.size(); i++) {
            tnTmp1.left = null;
            tnTmp1.right = ans.get(i);
            tnTmp1 = tnTmp1.right;

        }


    }

}
