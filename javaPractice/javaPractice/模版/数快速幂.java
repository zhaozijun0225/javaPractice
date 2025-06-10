package 模版;

public class 数快速幂 {
    public static long pow3(int a, int b){
        long ans = 1;
        while(b > 0){
            if((b & 1) == 1){
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }
        return ans;
    }

}
