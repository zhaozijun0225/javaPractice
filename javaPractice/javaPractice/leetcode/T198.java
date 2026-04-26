package leetcode;

public class T198 {

    public int rob(int[] nums) {

        int tmp1=0,tmp2=0,tmp3;

        for(int i = 0;i<nums.length;i++){
            tmp1 = Math.max(tmp2,tmp1+nums[i]);
            tmp3 = tmp2;
            tmp2 = tmp1;
            tmp1 = tmp3;
        }

        return tmp2;


    }
}
