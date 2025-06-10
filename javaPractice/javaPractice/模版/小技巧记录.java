package 模版;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;
import java.util.StringTokenizer;

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


//只取前2个数，后面的单独作为一个字符串：
String input = "12   34  56 786786";
//用\\s+正则表达式匹配，否则按空格匹配会在“   ”时产生空字符串
String[] sp=input.split("\\s+",3);
//字符串转数
int n = Integer.parseInt(br.readLine().trim());
//取其中部分字符串
String depName = token.substring(1);

//拼接字符串，仅两个推荐concat，多个推荐StringBUilder(用setLength清空)



//快读流 tokenizer解析每次从br取的“一行”
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int n = Integer.parseInt(st.nextToken());
long[] A = new long[n];
for (int i = 0; i < n; i++) {
    st = new StringTokenizer(br.readLine());
    A[i] = Long.parseLong(st.nextToken());
}

//用L表示大的数
Long a = 777777777777L;


