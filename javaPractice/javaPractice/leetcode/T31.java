package leetcode;

public class T31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int idx = n - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }


        int tmpInt1;
        int idx2 = n - 1;
        if (idx >= 0) {
            idx2 = n - 1;
            while (nums[idx2] <= nums[idx]) {
                idx2--;
            }
            tmpInt1 = nums[idx];
            nums[idx] = nums[idx2];
            nums[idx2] = tmpInt1;
        }

        int right = n - 1;
        for (int i = idx + 1; i < right; i++) {
            tmpInt1 = nums[i];
            nums[i] = nums[right];
            nums[right] = tmpInt1;
            right--;
        }


    }

}
