package csp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class T39_2 {
    static int[][] csp = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0, 0}
    };

    public static void main(String[] args) throws IOException {


//        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        int n = in.nextInt();
//        int L = in.nextInt();
//
//        int[][] nums = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                nums[i][j] = in.nextInt();
//            }
//        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[] ans = new int[L + 1];


        for (int i = 0; i <= n - 5; i++) {
            for (int j = 0; j <= n - 9; j++) {
                int minK = L + 1, maxK = -1;

                for (int a = 0; a < 5; a++) {
                    for (int b = 0; b < 9; b++) {
                        if (csp[a][b] == 0) {
                            maxK = Math.max(maxK, nums[i + a][j + b] + 1);
                        } else {
                            minK = Math.min(minK, nums[i + a][j + b]);
                        }
                    }
                }

                if (maxK <= minK && minK != L + 1 && maxK != -1) {
                    ans[maxK]++;
                    ans[minK + 1]--;
                }

            }
        }
        int arrSum = 0;
        for (int i = 0; i < L; i++) {
            arrSum += ans[i];
            if (arrSum > 0)
                System.out.println(i);
        }


    }
}
