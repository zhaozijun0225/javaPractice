package leetcode;

import java.util.*;

//滑动窗口
public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k)
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = dq.peekFirst();
        for (int i = k; i < nums.length; i++) {

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();

            }
            ans[i - k + 1] = nums[dq.peekFirst()];


        }
        return ans;


    }
}
