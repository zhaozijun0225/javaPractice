package leetcode;

import java.util.*;

public class T238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int m = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            m *= nums[i - 1];
            ans[i] = m;
        }
        m = 1;
        for(int i = nums.length-2;i>=0;i--){
            m *=nums[i+1];
            ans[i]*=m;


        }
        return ans;


    }

}
