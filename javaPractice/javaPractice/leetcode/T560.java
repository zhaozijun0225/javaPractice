package leetcode;

import java.util.*;


public class T560 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;


        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int ans = 0, sum = 0;
        mp.put(0, 1); //记录前缀和要初始化
        for (int i : nums) {
            sum += i;
            ans += mp.getOrDefault(sum - k, 0);
            mp.merge(sum,1,Integer::sum);

        }
        return ans;

    }
}
