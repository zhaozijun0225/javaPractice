package leetcode;

import java.util.ArrayList;
import java.util.List;
public class T78 {
    static List<List<Integer>> ans = new ArrayList<>();
    static void dfs(int[] nums,int idx,List<Integer> partAns){
        if (idx==nums.length){
            ans.add(new ArrayList<>(partAns));
            return;
        }

        dfs(nums,idx+1,partAns);
        partAns.add(nums[idx]);
        dfs(nums,idx+1,partAns);
        partAns.removeLast();
        return;
    }


    public static void main(String[] args){

        int[] nums = {0};
        int idx = 0;
        List<Integer> partAns = new ArrayList<>();
        dfs(nums,idx,partAns);

        System.out.println(ans);
    }
}
