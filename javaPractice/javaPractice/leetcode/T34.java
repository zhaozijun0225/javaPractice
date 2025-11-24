package leetcode;

import java.util.*;

public class T34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;


        int n = nums.length, l = 0, r = n - 1, mid;
        int[] ans = new int[]{-1, -1};

        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) {
                if (mid == n - 1) {
                    ans[0] = -1;
                    ans[1] = -1;
                    return ans;
                } else if (nums[mid + 1] == target) {
                    ans[0] = mid + 1;
                    break;
                } else {
                    l = mid + 1;

                }
            } else if (nums[mid] == target && mid == 0) {
                ans[0] = 0;
                break;
            } else {
                r = mid - 1;
            }

        }
        l = 0;
        r = n - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                if (mid == 0) {
                    ans[0] = -1;
                    ans[1] = -1;
                    return ans;
                } else if (nums[mid - 1] == target) {
                    ans[1] = mid - 1;
                    break;
                } else {
                    r = mid - 1;

                }
            } else if (nums[mid] == target && mid == n - 1) {
                ans[1] = n - 1;
                break;
            } else {
                l = mid + 1;
            }

        }

        return ans;


    }
}
