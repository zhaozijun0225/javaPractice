package leetcode;

import java.util.*;

public class T437 {
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

    static int count = 0;

    static void search(TreeNode tn, int target, List<Long> sumArr) {
        TreeNode[] tmp1 = new TreeNode[]{tn.left, tn.right};

        Long sum;
        for (TreeNode a : tmp1) {
            if(a!=null){
                sum = sumArr.getLast() + a.val;
                for (Long i : sumArr) {
                    if (sum - i == target) {
                        count++;
                    }
                }
                sumArr.add(sum);
                search(a, target, sumArr);
                sumArr.removeLast();
            }

        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        int targetSum = 8;


        count = 0;
        if(root==null)
            return count;
        if(root.val==targetSum)
            count++;

        List<Long> sumArr = new ArrayList<>();
        sumArr.add(0L);
        sumArr.add((long) root.val);
        search(root, targetSum, sumArr);
        return count;


    }


}
