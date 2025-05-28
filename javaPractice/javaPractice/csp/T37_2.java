package csp;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.*;


//class T37_2 {
//    static int[] rem = new int[10001];
//
//    static int dfs(int n, int[] value) {
//        int ans = 0;
//        int i = 0;
//        if (n == 0) {
//            return ans;
//        }
//
//
//        if (n > value.length) {
//            for (i = 1; i <= value.length; i++) {
//                if (rem[i] == -1) {
//                    rem[i] = dfs(i, value);
//                }
//                if (rem[n - i] == -1) {
//                    rem[n - i] = dfs(n - i, value);
//                }
//                ans = Math.max(ans, rem[i] + rem[n - i]);
//            }
//        } else {
//            for (i = 0; i <= n; i++) {
//                if (i == 0 || i == n) {
//
//                    ans = Math.max(ans, value[n-1]);
//                } else {
//                    if (rem[i] == -1) {
//                        rem[i] = dfs(i, value);
//                    }
//                    if (rem[n - i] == -1) {
//                        rem[n - i] = dfs(n - i, value);
//                    }
//                    ans = Math.max(ans, rem[i] + rem[n - i]);
//                }
//
//
//            }
//
//        }
//        rem[n] = ans;
//
//
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        int n, m;
//        n = in.nextInt();
//        m = in.nextInt();
//        int[] value = new int[m];
//        for (int i = 0; i < m; i++) {
//            value[i] = in.nextInt();
//        }
//        Arrays.fill(rem, -1);
//        rem[0] = 0;
//        int ans = dfs(n, value);
//
//        System.out.println(ans);
//    }
//
//}

class T37_2 {
    static int[] rem = new int[10001];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            value[i] = in.nextInt();
        }
        Arrays.fill(rem, -1);
        rem[0] = 0;

        int i, j, ans;
        for (i = 1; i <= n; i++) {
            ans = 0;
            for (j = i - 1; j >= i - m && j >= 0; j--) {
                ans = Math.max(ans, rem[j] + value[i - j - 1]);
            }
            rem[i] = ans;

        }


        System.out.println(rem[n]);
    }

}
