package leetcode;

import java.util.*;

public class T105 {
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

    static int findIdx(int[] order, int num1, int inorder_left, int inorder_right) {
        int i, idx1 = -1;
        for (i = inorder_left; i < inorder_right; i++) {
            if (order[i] == num1) {
                idx1 = i;
                break;
            }
        }

        return i;

    }


    static TreeNode construct(int[] preorder_complete, int[] inorder, int pre_idx, int inorder_left, int inorder_right) {
        int num1 = preorder_complete[pre_idx], idx1, i;
        TreeNode ans = new TreeNode();
        idx1 = findIdx(inorder, num1, inorder_left, inorder_right);

        if (idx1 == -1)
            return null;

        ans.val = num1;
        if (idx1 != inorder_left) {
            ans.left = construct(preorder_complete, inorder, pre_idx + 1, inorder_left, idx1);
        } else {
            ans.left = null;
        }

        if (idx1 != inorder_right - 1) {
            ans.right = construct(preorder_complete, inorder, pre_idx + (idx1 - inorder_left) + 1, idx1+1, inorder_right);
        } else {
            ans.right = null;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] preorder = new int[100], inorder = new int[100];


        TreeNode ans = construct(preorder, inorder, 0, 0, inorder.length);

        return ans;

    }


}
