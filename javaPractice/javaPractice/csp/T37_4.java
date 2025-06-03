package csp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class T37_4 {

    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    static long MOD = 998244353;

    static class split {
        long r, g;

        split(long r, long g) {
            this.r = r;
            this.g = g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] A = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0, thisAns = 0;
        split tmp1, tmp2;

        List<split> l = new ArrayList<split>(64);
        for (int i = 0; i < n; i++) {
            List<split> tmp = new ArrayList<split>(64);
            l.add(new split(i + 1, A[i]));
            for (int j = 0; j < l.size(); j++) {
                tmp1 = l.get(j);
                tmp1.g = gcd(tmp1.g, A[i]);

                if (tmp.isEmpty()) {
                    tmp.add(tmp1);
                } else if (tmp.getLast().g == tmp1.g) {
                    tmp.getLast().r = tmp1.r;
                } else {
                    tmp.add(tmp1);
                }
            }

            l = tmp;
            thisAns = 0;
            thisAns = ((1 + l.get(0).r) * l.get(0).r / 2 * l.get(0).g) % MOD;

            for (int j = 1; j < l.size(); j++) {
                tmp1 = l.get(j);
                tmp2 = l.get(j - 1);
                thisAns = (thisAns + (((1 + tmp1.r) * tmp1.r) - ((1 + tmp2.r) * tmp2.r)) / 2 * tmp1.g) % MOD;
            }


            ans = (ans + thisAns * (i + 1)) % MOD;


        }


        System.out.println(ans);


    }
}
