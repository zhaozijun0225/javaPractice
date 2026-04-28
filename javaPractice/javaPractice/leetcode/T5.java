package leetcode;

public class T5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int ansLeft = 0;
        int ansRight = 0;
        int max = -1;
        String res = "";
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            while (left >= 0 && right < n && chars[left] == chars[right]) {
                left--;
                right++;
            }
            if(right-left-1>max){
                max = right-left-1;
                res = s.substring(left+1,right);
            }

        }
        return res;


    }
}
