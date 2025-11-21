package leetcode;

import java.util.*;

public class T48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        int i, j, tmp, m = matrix.length, n = matrix[0].length;
        //对角线替换
        for (i = 0; i < m; i++) {
            for (j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }

        }
        //左右替换
        for (i = 0; i < m; i++) {
            for (j = 0; j < n / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }

        }
//        矩阵转置:matrix[i][j] ↔ matrix[j][i]
//        矩阵水平镜像:matrix[i][j] ↔ matrix[i][n-1-j]
//        矩阵垂直镜像:matrix[i][j] ↔ matrix[m-1-i][j]
//        矩阵顺时针旋转90度， new_matrix[j][n-1-i] = matrix[i][j],就相当于垂直镜像+转置
//        矩阵顺时针旋转180度，new_matrix[n-1-i][n-1-j] = matrix[i][j],就相当于水平镜像+垂直镜像
//        矩阵逆时针旋转90度，new_matrix[n-1-j][i] = matrix[i][j],就相当于水平镜像+转置


    }
}
