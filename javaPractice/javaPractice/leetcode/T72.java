package leetcode;

import java.util.Arrays;

public class T72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[2][word2.length() + 1];
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();

        Arrays.setAll(dp[0], id -> id);
        int i, j;
        for (i = 1; i <= w1.length; i++) {
            dp[i % 2][0] = i;
            for (j = 1; j <= w2.length; j++) {

                dp[i % 2][j] = 1 + Math.min(Math.min(dp[(i - 1) % 2][j - 1] - (w1[i - 1] == w2[j - 1] ? 1 : 0), dp[(i - 1) % 2][j]), dp[i % 2][j - 1]);


            }

        }
        return dp[(i - 1) % 2][w2.length];


    }
}
