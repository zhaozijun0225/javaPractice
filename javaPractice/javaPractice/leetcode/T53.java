package leetcode;

/**
 * @Author: zijun.zhao
 * @Date: 2026/6/11 上午3:46
 */

public class T53 {
    private class state {
        int lsum;
        int rsum;
        int asum;
        int msum;

        state(int lsum, int rsum, int asum, int msum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.asum = asum;
            this.msum = msum;
        }
    }

    public int maxSubArray(int[] nums) {
        state s = getMax(nums, 0, nums.length - 1);
        return s.msum;
    }

    state getMax(int[] nums, int l, int r) {
        if (r == l)
            return new state(nums[l], nums[l], nums[l], nums[l]);

        state s1 = getMax(nums, l, (l + r) / 2);
        state s2 = getMax(nums, (l + r) / 2 + 1, r);

        int lsum = Math.max(s1.lsum, s1.asum + s2.lsum);
        int rsum = Math.max(s2.rsum, s2.asum + s1.rsum);
        int asum = s1.asum + s2.asum;
        int msum = Math.max(Math.max(s1.msum, s2.msum), s1.rsum + s2.lsum);
        return new state(lsum, rsum, asum, msum);


    }
}
