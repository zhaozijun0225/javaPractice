package leetcode;

public class T169 {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int sc = 0;
        for(int x:nums){
            if(sc==0){
                ans = x;
                sc = 1;
            }else{
                sc+=ans==x?1:-1;
            }


        }
        return ans;
    }

}
