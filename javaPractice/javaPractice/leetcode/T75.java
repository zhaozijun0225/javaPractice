package leetcode;

public class T75 {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int p0 = 0, p2 = n - 1;

        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 2) {
                while (i <= p2) {
                    if (nums[i] != 2) {
                        break;
                    }
                    int tmpInt1 = nums[p2];
                    nums[p2] = nums[i];
                    nums[i] = tmpInt1;
                    p2--;


                }
            }
            if (nums[i] == 0) {
                int tmpInt1 = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmpInt1;
                p0++;
            }




        }


    }
}
