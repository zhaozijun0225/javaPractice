package 模版;

//这是System.in输入

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class Main{
    public void run() throws IOException {
        PrintWriter pw = new PrintWriter(System.out, false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] strArr = br.readLine().split("\\s+"); //每次读一行
        strArr = br.readLine().split("\\s+", 2);  //只把第一个空格当成分隔符（只分两段）
        int n = Integer.parseInt(strArr[0]);
        //在这里写你的代码


        pw.printf("%d %d\n", 1, 2);
        br.close();
        pw.flush();
        pw.close();

    }

    public static void main(String[] args){
        new csp.Main().run();
    }
}



//这是自己在本地测试样例时候用的（下面的是老版本，更好的看上面的）

import java.io.*;
import java.util.*;
public class Main_Test {

    public void run(String filename) throws FileNotFoundException {
        File file = new File(filename);
      Scanner sc = new Scanner(file);
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        //在此输入您的代码...
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("index.out")));
            bw.write(String.valueOf(12312312));//str表示写入文件的内容
            bw.flush();//立刻将缓存区的数据写入数据流
            bw.close();//将BufferedWriter流关闭
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new Main_Test().run("eg1.txt");
    }
}