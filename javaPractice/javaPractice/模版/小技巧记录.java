package 模版;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InaccessibleObjectException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
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
//用\\s+正则表达式匹配，否则按空格匹配会在“   ”时(多个空格)产生空字符串
String[] sp=input.split("\\s+",3);
//字符串转数
int n = Integer.parseInt(br.readLine().trim());
//取其中部分字符串
String depName = token.substring(1);

//拼接字符串，仅两个推荐concat，多个推荐StringBuilder(用setLength(0)清空)(append\insert\delete\deleteCharAt\setLength\replace\reverse)
//多次添加单个字符，可以先构造一个stringBuilder，用append和deleteCharAt



//读N进制字符串  一定要注意题目给的字符串的进制！！！！！
String tmp = "010101";
int tmpInt = Integer.parseInt(tmp,2);
long tmplong = Long.parseLong(tmp,2);

//读N进制字符
// 示例1: 字符'3'在基数16下的数值(如果是十六进制，字符要是大写的)((String)xxx.toUpperCase())
char c1 = 'A';
int in1 = Character.digit(c1, 16);
System.out.println("数值为: " + in1); // 输出: 数值为: 10

//输出为二进制字符串,一定要注意题意要求的二进制位数！这里转的都是最短优先的
int decimalValue = 10;
String BinaryString2 = Integer.toString(decimalValue,2);//最通用的的写法
String binaryString = Integer.toBinaryString(decimalValue);  // 将数字转换为二进制字符串
//转成5进制字符串
String BinaryString2 = Integer.toString(decimalValue,3);
// 输出结果
System.out.println(binaryString);  // 输出：1010
//要注意，转的东西都是是最短优先的！！不一定是四位，不要惯性思维了！
String.format("%4s", Integer.toBinaryString(decimalValue)).replace(' ', '0');  // 转换为二进制，并确保四位



//快读流 tokenizer解析每次从br取的“一行”
BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
StringTokenizer st = new StringTokenizer(br.readLine());
int n = Integer.parseInt(st.nextToken());
//st那行开始可以用String[] sp=input.split("\\s+");,更优雅
long[] A = new long[n];
for (int i = 0; i < n; i++) {
    st = new StringTokenizer(br.readLine());
    A[i] = Long.parseLong(st.nextToken());
}

//快速输出 （System.out.print遇到换行符时，会频繁触发flush，也就是强制把缓冲区里的数据刷到操作系统的内核缓冲区，最终通过系统调用写入硬件（如控制台）
// 每次flush()都会把缓冲区里的 “一行数据” 刷到内核，相当于 “用小勺子频繁舀水”，而不是 “用大桶一次性运水”—— 完全没利用到缓冲区的 “批量优化” 价值。
//从 Java 程序的用户态到操作系统内核的内核态切换，是非常耗时的操作：
//每次flush()最终会调用操作系统的write()系统调用；
//系统调用需要保存当前进程的上下文（寄存器、栈等）、切换特权级、执行内核逻辑，再恢复上下文 —— 这个过程的耗时远大于单纯的内存拷贝。
//频繁调用println会放大这种开销：比如循环输出 1 万行，就会产生 1 万次系统调用和上下文切换，累积起来性能损耗很明显。
// 这个会切换用户态内核态，造成开销，很坑！！！！）
// IO优化：使用PrintWriter减少IO开销
PrintWriter pw = new PrintWriter(System.out);//可以有第二个参数，指定是否自动刷新缓冲区，默认是false
pw.printf("%s %s%n", receiver, sender);




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



大整数BigInteger，大浮点数BIgDecimal
使用方法：https://blog.csdn.net/2302_79730293/article/details/144947000
BigInteger a = BigInteger.valueOf(1);//转换long时
BigInteger b = new BigInteger(s,10); //转换数字s时(使用时要注意进制)



s = String.format("-%11s",s); //左对齐
s = String.format("%11s",s);  //右对齐


java虽然没有unsigned类型，但是有无符号移位>>>



//%n是格式化占位符，与\n一样，但是%n会由java自己判断当前系统，并作出换行
//场景	        平台无关表示	            系统特有字符（硬编码风险）
//格式化输出换行	%n	                    \n / \r\n
//字符串拼接换行	System.lineSeparator()	\n / \r\n
//文件路径分隔	File.separator	        \ / /
//多路径分隔	File.pathSeparator	        ; / :\



//hashmap有entrySet()\keySet()可以遍历，entry是一个键值对
//for (Map.Entry<String, Integer> entry : map.entrySet()) {
//      String k = entry.getKey(); // 键
//      Integer v = entry.getValue(); // 值
//      System.out.println("key: " + k + ", value: " + v);
//        }


//        System.out.printf("%-10d",1);   左对齐
//        System.out.printf("%010d",1);  左补0，与上面那条不能共用
//        System.out.printf("%-10.3f",1.0);  总长度为10


//List除了可以根据下标remove，也可以根据对象remove,但是只会移除第一个出现的