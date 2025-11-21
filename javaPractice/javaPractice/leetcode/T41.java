package leetcode;

import java.util.*;


public class T41 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0};


        int n = nums.length, tmp;
        for (int i = 0; i < n; i++) {
            while (nums[i] <= n && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;

            }
        }

        for (int i = 0; i < n; i++) {
            return i + 1;

        }
        return n + 1;

    }
}
