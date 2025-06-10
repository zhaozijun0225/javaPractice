package 模版;

public class gcd {
    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

}
