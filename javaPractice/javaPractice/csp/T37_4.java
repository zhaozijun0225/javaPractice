package csp;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class T37_4 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    static int MOD=998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int ans = 0;
        int [] cal = new int[n];
        Arrays.setAll(cal, i->A[i]);
        for (int i = 0; i < n; i++) {

        }



    }
}
