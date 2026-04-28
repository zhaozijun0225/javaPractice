package leetcode;

public class T152 {
    public int maxProduct(int[] nums) {
        int fMax = 1, fMin = 1,ans = Integer.MIN_VALUE,tmpI1,tmpI2;
        for (int i : nums) {

            tmpI1 = Math.max(Math.max(fMax * i, fMin * i), i);
            tmpI2 = Math.min(Math.min(fMin * i, fMax * i), i);
            fMax = tmpI1;
            fMin = tmpI2;
            ans = Math.max(ans, fMax);
        }
        return ans;


    }
}
