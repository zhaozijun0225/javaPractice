package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class T84 {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> dq = new ArrayDeque();
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        int ans = 0;
        int tmpI1;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && heights[dq.peek()] >= heights[i]) {
                tmpI1 = dq.pop();
                right[tmpI1] = i;
                ans = Math.max(ans, heights[tmpI1] * (right[tmpI1] - left[tmpI1] - 1));
            }
            left[i] = dq.isEmpty() ? -1 : dq.peek();
            dq.push(i);
        }
        while (!dq.isEmpty()) {
            tmpI1 = dq.pop();
            ans = Math.max(ans, heights[tmpI1] * (right[tmpI1] - left[tmpI1] - 1));
        }
        return ans;



    }

    public static void main(String[] args) {

    }
}
