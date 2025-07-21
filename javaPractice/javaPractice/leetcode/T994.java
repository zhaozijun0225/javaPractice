package leetcode;

import java.util.*;

public class T994 {
    public static void main(String[] args) {
        int[][] grid = {{0}};

        int i, j, M = grid.length, N = grid[0].length;
        int[] flag = new int[M * N];
        int[][] time = new int[M][N];

        Deque<Integer> bfsY = new ArrayDeque<>();
        Deque<Integer> bfsX = new ArrayDeque<>();

        for (i = 0; i < M; i++) {
            for (j = 0; j < N; j++) {
                time[i][j] = Integer.MAX_VALUE;

            }
        }


        int tmp1, tmp2, count;
        for (i = 0; i < M; i++) {
            for (j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    Arrays.fill(flag, 0);
                    count = 1;
                    bfsY.add(i);
                    bfsX.add(j);
                    flag[i * N + j] = 1;
                    time[i][j] = count < time[i][j] ? count : time[i][j];
                    while (!bfsY.isEmpty()) {
                        tmp1 = bfsY.poll();
                        tmp2 = bfsX.poll();
                        count = time[tmp1][tmp2]+1;

                        if ((tmp1 - 1 >= 0 && tmp1 - 1 < M) && (grid[tmp1 - 1][tmp2] == 1 || grid[tmp1 - 1][tmp2] == 2) && flag[(tmp1 - 1) * N + tmp2] != 1) {
                            bfsY.add(tmp1 - 1);
                            bfsX.add(tmp2);
                            flag[(tmp1 - 1) * N + tmp2] = 1;
                            time[tmp1-1][tmp2] = count < time[tmp1-1][tmp2] ? count : time[tmp1-1][tmp2];
                        }
                        if ((tmp2 - 1 >= 0 && tmp2 - 1 < N) && (grid[tmp1][tmp2 - 1] == 1 || grid[tmp1][tmp2 - 1] == 2) && flag[tmp1 * N + (tmp2 - 1)] != 1) {
                            bfsY.add(tmp1);
                            bfsX.add(tmp2 - 1);
                            flag[tmp1 * N + (tmp2 - 1)] = 1;
                            time[tmp1][tmp2-1] = count < time[tmp1][tmp2-1] ? count : time[tmp1][tmp2-1];

                        }
                        if ((tmp1 + 1 >= 0 && tmp1 + 1 < M) && (grid[tmp1 + 1][tmp2] == 1 || grid[tmp1 + 1][tmp2] == 2) && flag[(tmp1 + 1) * N + tmp2] != 1) {
                            bfsY.add(tmp1 + 1);
                            bfsX.add(tmp2);
                            flag[(tmp1 + 1) * N + tmp2] = 1;
                            time[tmp1+1][tmp2] = count < time[tmp1+1][tmp2] ? count : time[tmp1+1][tmp2];

                        }
                        if ((tmp2 + 1 >= 0 && tmp2 + 1 < N) && (grid[tmp1][tmp2 + 1] == 1 || grid[tmp1][tmp2 + 1] == 2) && flag[tmp1 * N + (tmp2 + 1)] != 1) {
                            bfsY.add(tmp1);
                            bfsX.add(tmp2 + 1);
                            flag[tmp1 * N + (tmp2 + 1)] = 1;
                            time[tmp1][tmp2+1] = count < time[tmp1][tmp2+1] ? count : time[tmp1][tmp2+1];

                        }


                    }


                }

            }
        }
        int ans = 0;
        for (i = 0; i < M; i++) {
            for (j = 0; j < N; j++) {
                if (grid[i][j] == 2 || grid[i][j] == 1) {
                    if (time[i][j] == Integer.MAX_VALUE) {
                        ans = 0;
                        break;
                    }
                    if (time[i][j] != Integer.MAX_VALUE) {
                        ans = time[i][j] > ans ? time[i][j] : ans;
                    }

                }

            }
            if (ans == 0) {
                break;
            }
        }

        ans--;


        System.out.println(ans);

    }


}
