package leetcode;

import java.util.*;


public class T560 {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        int ans = 0;
        map.merge(0, 1, Integer::sum);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans+=map.getOrDefault(sum-k,0);
            map.merge(sum, 1, Integer::sum);

        }


        return ans;
    }
}
