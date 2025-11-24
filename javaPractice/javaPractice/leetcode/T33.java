package leetcode;

import java.util.*;

public class T33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;


        int n = nums.length, lastNum = nums[n - 1];
        int l = 0, r = n - 1, mid;
        boolean isLeft = false;
        if (target <= lastNum)
            isLeft = false;
        else
            isLeft = true;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] <= lastNum && isLeft) {
                    r = mid - 1;
                } else if (nums[mid] > lastNum && !isLeft) {
                    l = mid + 1;
                } else {
                    if(nums[mid]>target){
                        r = mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
            }


        }
        return -1;


    }
}
