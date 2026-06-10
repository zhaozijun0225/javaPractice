package leetcode;

/**
 * @Author: zijun.zhao
 * @Date: 2026/6/11 上午4:39
 */

public class T189 {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k % nums.length-1);
        reverse(nums,k % nums.length,nums.length-1);
    }

    private void reverse(int[] nums, int l, int r) {

        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;

            l++;
            r--;
        }


    }
}
