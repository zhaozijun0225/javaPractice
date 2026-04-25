package leetcode;

public class T208 {
    private TreeNode head;

    public Trie() {
        head = new TreeNode();
    }


    public void insert(String word) {
        TreeNode current = head;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TreeNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode current = head;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] != null) {
                current = current.children[c - 'a'];
            } else
                return false;
        }
        if (current.isEnd)
            return true;
        else
            return false;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = head;
        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] != null) {
                current = current.children[c - 'a'];
            } else
                return false;
        }

            return true;

    }


    class TreeNode {
        private TreeNode[] children;
        boolean isEnd;

        TreeNode() {
            children = new TreeNode[26];
            isEnd = false;
        }


    }
}
