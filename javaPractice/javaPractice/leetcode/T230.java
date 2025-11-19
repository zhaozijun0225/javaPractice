package leetcode;

import java.util.*;


public class T230 {
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
        int k = 1;

        int ans;
        Deque<TreeNode> st = new ArrayDeque<TreeNode>();
        TreeNode tmpTN1 = root;
        while (!st.isEmpty() || tmpTN1!=null) {
            while (tmpTN1 != null) {
                st.push(tmpTN1);
                tmpTN1 = tmpTN1.left;
            }
            tmpTN1 = st.pop();
            k--;
            if(k==0){
                ans = tmpTN1.val;
            }
            tmpTN1 = tmpTN1.right;



        }

        return ans;


    }
}
