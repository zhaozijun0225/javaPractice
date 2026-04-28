package leetcode;

import java.util.*;

public class T32 {
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dq.push(i);
            } else if (!dq.isEmpty()) {
                int j = dq.pop();
                dp[i] = i - j + 1 + (j > 0 ? dp[j - 1] : 0);
                max= Math.max(max,dp[i]);
            }


        }
        return max;


    }
}
