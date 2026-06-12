package leetcode;

import java.util.*;

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, top = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>((int) (bottom * right / 0.75 + 1));
        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }


            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;


    }
}
