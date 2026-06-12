package leetcode;

import java.util.*;

public class T48 {

//        矩阵转置:matrix[i][j] ↔ matrix[j][i]
//        矩阵水平镜像:matrix[i][j] ↔ matrix[i][n-1-j] 或者搞left、right双向奔赴
//        矩阵垂直镜像:matrix[i][j] ↔ matrix[m-1-i][j] 或者搞top、buttom双向奔赴
//        矩阵顺时针旋转90度， new_matrix[j][n-1-i] = matrix[i][j],就相当于垂直镜像+转置
//        矩阵顺时针旋转180度，new_matrix[n-1-i][n-1-j] = matrix[i][j],就相当于水平镜像+垂直镜像
//        矩阵逆时针旋转90度，new_matrix[n-1-j][i] = matrix[i][j],就相当于水平镜像+转置

    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int top = 0, bottom = m - 1; top < bottom; top++, bottom--) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[top][j];
                matrix[top][j] = matrix[bottom][j];
                matrix[bottom][j] = tmp;
            }
        }

        for (int i = 0;i<m;i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }




    }

}
