package 模版;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;

public class 小技巧记录 {

}
//eclipse别忘查查怎么自动提示词


//二维数组打平
int[] a = new int[m * n];
for (int i = 0; i < m; i++) {
    System.arraycopy(values[i], 0, a, i * n, n);
}
Arrays.sort(a);


//setAll方法，快速初始化，ids是一个数组
Arrays.setAll(ids, i -> i);
Arrays.fill(ans, -1);
Arrays.sort(ids, (a, b) -> Long.compare(op[a], op[b]));


//判断结尾的方法，如果是非EOF符号则将结束符号作为hasNext的参数
while(sc.hasNextInt());


//输入
Scanner cin = new Scanner(new BufferedInputStream(System.in));


//栈推荐用deque


