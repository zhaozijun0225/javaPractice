package 模版;

//这是System.in输入

import java.util.*;
public class Main{
  public void run(){
      Scanner sc = new Scanner(System.in);
      //在这里写你的代码
  }
  public static void main(String[] args){
  new Main().run();
  }
}



//这是自己在本地测试样例时候用的
import java.io.*;
import java.util.*;
public class Main_Test {

  public void run(String filename) throws FileNotFoundException {
      File file = new File(filename);
      Scanner sc = new Scanner(file);
//      Scanner cin = new Scanner(new BufferedInputStream(System.in));
      
      //在此输入您的代码...
      sc.close();
  }


  public static void main(String[] args) throws FileNotFoundException {
      new Main_Test().run("eg1.txt");
  }
}