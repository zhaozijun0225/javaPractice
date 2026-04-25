package leetcode;

import java.util.*;

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        int maxCount = Collections.max(map.values());

        ArrayList<Integer>[] bk = new ArrayList[maxCount + 1];
        Arrays.setAll(bk, _ -> new ArrayList<Integer>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bk[entry.getValue()].add(entry.getKey());
        }

        int j = 0;
        for (int i = maxCount; j<k; i--) {

            for (Integer tmp : bk[i]) {
                ans[j++] = tmp;
            }
        }


        return ans;
    }


}
