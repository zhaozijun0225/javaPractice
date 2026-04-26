package leetcode;

import java.util.Arrays;

public class T322 {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount + 1];
        Arrays.fill(ans,0x3fffffff);
        ans[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount+1; j++) {
                ans[j] = Math.min(ans[j],ans[j-coins[i]]+1);

            }

        }
        return ans[amount]==0x3fffffff?-1:ans[amount];

    }
}
