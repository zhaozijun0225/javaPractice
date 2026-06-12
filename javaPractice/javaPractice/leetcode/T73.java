package leetcode;

/**
 * @Author: zijun.zhao
 * @Date: 2026/6/13 上午3:16
 */

public class T73 {

    public void setZeroes(int[][] matrix) {
        boolean flg = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flg = true;
            }

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }

        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flg) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
