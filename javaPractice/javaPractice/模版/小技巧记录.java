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

//拼接字符串，仅两个推荐concat，多个推荐StringBuilder(用setLength清空)(append\insert\delete\deleteCharAt\setLength\replace\reverse)
//多次添加单个字符，可以先构造一个stringBuilder，用append和deleteCharAt





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

//枚举字符串：
//至少有一个1在字符串，枚举字符串的情况
//简单枚举：枚举1第一次出现的位置，保证位置前面没有1（或者最后一次出现）
//枚举csp和ccfpark在串中至少出现一次，（2个分别在前、后）有多少种可能？
//简单枚举：枚举csp第一次出现的位置和ccfpark最后一次出现的位置，保证csp前没有csp，ccfpark后面没有ccfpark
//长度很长时：dp，假设字符串正则表达式为*ccf*cspark*，设dp[i][j]表示到串的第i位，匹配了正则表达式的第j位的数量，最后统计dp[n-1][10]+dp[n-1][11]
//更高级的做法：转移矩阵优化dp+矩阵快速幂，把dp数组看作一个列向量，每次变换相当于左乘了一个转移矩阵，对于连续n次递推，相当于转移矩阵的n次幂乘dp[0],如果有特殊情况，相当于连乘

cnt.merge(s, 1, Integer::sum); // cnt[s]++
cnt.merge(s, -1, Integer::sum); // cnt[s]-- 恢复现场（撤销 cnt[s]++）

Map.merge //若key s存在，则会调用第三个lambda函数，(oldValue,newValue)->xxxxx;若key s不存在，则直接赋值第二个参数（newValue）


deque方法记录
返回null/false        抛出异常
peekLast             getLast
offerLast            addLast


//        System.out.println(1e18 + 0.5 == 1e18);  true  小心浮点数


System.arraycopy(src,idx,dst,idx,len);  //数组复制
int[] a = Arrays.copyOf(src,dstLen); //超出src长度时会补0