package leetcode;

import java.util.*;

class T200 {

    static int[][] flag;
    static int N;

    static void dfs(int i, int j, char[][] grid) {
        if (i > grid.length - 1 || j > grid[0].length - 1 || i < 0 || j < 0 || flag[i][j]==1 || grid[i][j]=='0')
            return;

        flag[i][j] = 1;
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }};

        flag = new int[grid.length][grid[0].length];


        int i, j;
        N = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && flag[i][j] == 0) {
                    dfs(i, j, grid);
                    N++;
                }
            }
        }
        System.out.println(N);
    }
}
