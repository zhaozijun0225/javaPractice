package csp;

import java.io.*;
import java.util.*;

public class T30_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] Q = new int[n][d], K = new int[n][d], V = new int[n][d];
        int[] W = new int[n];
        long[][] ans = new long[n][d], tmp = new long[d][d];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < d; j++) {
                Q[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < d; j++) {
                K[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < d; j++) {
                V[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
//            System.out.println(st.nextToken());
            W[j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < n; k++) {
                    tmp[i][j] += (long) K[k][i] * V[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < d; k++) {
                    ans[i][j] += (long) W[i] * Q[i][k] * tmp[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }



    }


}
