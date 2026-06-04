package leetcode;
import java.util.*;
import java.io.*;


public class T1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);

        for(int i =0;i<nums.length;i++){

            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.putIfAbsent(nums[i],i);
        }
        return null;


    }
}
