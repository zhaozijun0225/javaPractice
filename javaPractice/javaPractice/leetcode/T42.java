package leetcode;

//这是自己在本地测试样例时候用的
import java.io.*;
import java.util.*;

import javax.swing.tree.FixedHeightLayoutCache;

public class T42 {
    public int trap(int[] height) {
        int n  = height.length;
        int maxLeft = 0,maxRight = 0;
        int left = 0,right = n-1;
        int ans = 0;

        while(left<=right){

            if(height[left]<=height[right]){
                maxLeft = Math.max(maxLeft,height[left]);
                ans+=maxLeft-height[left];
                left++;
            }else{
                maxRight = Math.max(maxRight,height[right]);
                ans+=maxRight-height[right];
                right--;
            }


        }





        return ans;
    }

}