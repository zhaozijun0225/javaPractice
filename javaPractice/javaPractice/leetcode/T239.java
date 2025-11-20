package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//滑动窗口
public class T239 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;


        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> qe = new ArrayDeque<>(k);
        int i;
        for (i = 0; i < k; i++) {
            while (!qe.isEmpty() && nums[qe.peekLast()] <= nums[i]) {
                qe.pollLast();
            }
            qe.offerLast(i);

        }
        ans[0] = nums[qe.peekFirst()];

        for (i = k; i < n; i++) {
            while (!qe.isEmpty() && nums[qe.peekLast()] <= nums[i]) {
                qe.pollLast();
            }
            qe.offerLast(i);
            while (qe.peekFirst() < i - k + 1) {
                qe.pollFirst();
            }
            ans[i - k + 1] = nums[qe.peekFirst()];
        }
        return ans;

    }
}
