package leetcode;

import java.util.Arrays;

public class T64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]  =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[j+1] = Math.min(dp[j],dp[j+1])+grid[i][j];
            }
        }
        return dp[n];




    }
}
