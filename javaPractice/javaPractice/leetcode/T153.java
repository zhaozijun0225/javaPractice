package leetcode;

public class T153 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};

        int n = nums.length, i = 0, j = n - 1;
        int leftLimit = nums[0], mid;

        if(nums[n-1]>nums[0]||n<2)
            return nums[0];

        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] >= leftLimit) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }

        }


        return nums[i];

    }
}
