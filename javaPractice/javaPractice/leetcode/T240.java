package leetcode;

import java.util.*;


public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int x = n - 1, y = 0;
        while (x >= 0 && y < m) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                x--;
            } else {
                y++;
            }

        }
        return false;


    }
}
