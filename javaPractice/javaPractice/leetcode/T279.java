package leetcode;

import java.util.Arrays;

public class T279 {


    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j < n + 1; j++) {
                ans[j] = Math.min(ans[j], ans[j - i * i] + 1);
            }

        }
        return ans[n];

    }


}
