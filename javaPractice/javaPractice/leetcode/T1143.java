package leetcode;

public class T1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int[][] dp = new int[2][t2.length + 1];
        int max = 0;
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                dp[i % 2][j] = (t1[i - 1] == t2[j - 1]) ? dp[(i + 1) % 2][j - 1] +1 : Math.max(dp[i % 2][j - 1], dp[(i + 1) % 2][j]);
                max = Math.max(max,dp[i % 2][j]);
            }
        }
        return max;


    }
}
