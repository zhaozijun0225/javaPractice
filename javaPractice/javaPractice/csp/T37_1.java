package csp;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.*;


class T37_1 {
    public static int cal(int x, int b, int c) {
        return x * x + b * x + c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int b, c, l, r;
        b = in.nextInt();
        c = in.nextInt();
        l = in.nextInt();
        r = in.nextInt();
        BigInteger ans = BigInteger.ZERO;
        int i = (l % 2 == 0 ? l : l + 1);
        for (; i <= r; i += 2) {
            ans = ans.add(BigInteger.valueOf(cal(i, b, c)));
        }
        System.out.println(ans.multiply(BigInteger.valueOf(2)));

    }

}
