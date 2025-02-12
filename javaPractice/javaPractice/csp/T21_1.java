package csp;

import java.io.*;
import java.util.*;


//这是自己在本地测试样例时候用的
public class T21_1 {

  public void run(String filename) throws FileNotFoundException {
      File file = new File(filename);
      Scanner sc = new Scanner(file);
      
      int n=sc.nextInt();
      int sum=0;
      for (int i = 0; i < n; i++) {
		sum+=sc.nextInt()*sc.nextInt();
		
		
	}s
      
      
      
      System.out.println(sum);
      
      sc.close();
  }


  public static void main(String[] args) throws FileNotFoundException {
      new T21_1().run("./csp/eg1.in");
      
  }
}



 
