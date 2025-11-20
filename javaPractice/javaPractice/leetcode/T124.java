package leetcode;

public class T124 {
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

    static int ans = Integer.MIN_VALUE;

    static int search(TreeNode root) {
        if (root == null)
            return 0;
        int l = Math.max(search(root.left),0), r = Math.max(search(root.right),0);
        ans = Math.max(ans, l + root.val + r);


        return Math.max(l + root.val, r + root.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);


        search(root);

        return ans;


    }
}
