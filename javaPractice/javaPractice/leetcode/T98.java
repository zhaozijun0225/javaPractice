package leetcode;

import java.util.*;

import com.sun.source.tree.Tree;

public class T98 {
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
        Deque<TreeNode> st = new ArrayDeque<TreeNode>();
        TreeNode tmp = root;
        boolean ans = true;
        int minNum = Integer.MIN_VALUE;
        boolean isFirst = true;
        while (st.size() != 0 || tmp != null){
            while (tmp != null){
                st.push(tmp);
                tmp = tmp.left;
            }
            tmp = st.pop();
            if(isFirst){
                minNum = tmp.val;
                isFirst = false;
            }
            else{
                if(tmp.val>minNum){
                    minNum = tmp.val;
                }
                else{
                    ans = false;
                    break;
                }
            }
            tmp = tmp.right;

        }
        return ans;


    }
}
