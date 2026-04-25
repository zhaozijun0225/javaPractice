package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> dq = new ArrayDeque();
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        dq.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]) {
                int j = dq.pop();
                ans[j] = i - j;
            }
            dq.push(i);

        }
        return ans;


    }
}
