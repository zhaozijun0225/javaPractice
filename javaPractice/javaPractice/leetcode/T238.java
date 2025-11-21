package leetcode;

import java.util.*;

public class T238 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};


        int n = nums.length, i;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int l = nums[0];
        for (i = 1; i < nums.length; i++) {
            ans[i] = l;
            l *= nums[i];
        }
        int R = nums[n - 1];
        for (i = nums.length - 2; i >= 0; i--) {
            ans[i] *= R;
            R *=nums[i];

        }
        return ans;


    }

}
