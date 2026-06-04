package leetcode;

public class T283 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i]!=0){

                nums[idx++] = nums[i];

            }


        }

        for(;idx< nums.length;idx++){
            nums[idx] = 0;
        }
    }

}
