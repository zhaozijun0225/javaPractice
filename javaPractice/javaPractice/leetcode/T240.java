package leetcode;

import java.util.*;


public class T240 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 4;


        int m = matrix.length, n = matrix[0].length;
        int sy = 0,sx = n-1;
        while(sy<m && sx>=0){

            if(matrix[sy][sx]==target)
                return true;
            else if(matrix[sy][sx]<target)
                sy++;
            else
                sx--;






        }
        return false;



    }
}
