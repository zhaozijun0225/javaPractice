package leetcode;

import java.util.*;
import java.io.*;

public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int third = nums.length - 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < third && nums[j] + nums[third] > target)
                    third--;
                if(j==third)
                    break;

                if(nums[j]+nums[third]==target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[third]);
                    ans.add(tmp);


                }

            }


        }
        return ans;


    }
}
