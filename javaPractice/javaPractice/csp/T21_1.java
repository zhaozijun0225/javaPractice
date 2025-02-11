package csp;

import java.io.*;
import java.util.*;


//这是自己在本地测试样例时候用的
public class T21_1 {

  public void run(String filename) throws FileNotFoundException {
      File file = new File(filename);
      Scanner sc = new Scanner(file);
      
      //在此输入您的代码...
      sc.close();
  }


  public static void main(String[] args) throws FileNotFoundException {
      new T21_1().run("eg1.txt");
  }
}