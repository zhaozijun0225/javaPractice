package leetcode;

import java.util.*;
import java.util.concurrent.BlockingDeque;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String stmp : wordDict) {
            maxLen = Math.max(stmp.length(), maxLen);
        }

        HashSet<String> set = new HashSet<>(wordDict);

        int n = s.length();
        Boolean[] dp = new Boolean[n + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if (dp[i]) {break;}
            }


        }
        return dp[n];


    }


}
