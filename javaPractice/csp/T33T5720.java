package csp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T33T5720 {

	  public void run(String filename) throws FileNotFoundException {
	      File file = new File(filename);
	      Scanner sc = new Scanner(file);
	      
	      int n1=sc.nextInt(),n2=sc.nextInt();
	      Set <String> set1=new HashSet<String>(),set2=new HashSet<String>();
	      String tmp;
	      for (int i = 0; i < n1; i++) {
			tmp=sc.next();
			tmp=tmp.toLowerCase();
			set1.add(tmp);
	      }
	      for (int i = 0; i < n2; i++) {
				tmp=sc.next();
				tmp=tmp.toLowerCase();
				set2.add(tmp);
		  }
	      Set<String> unionSet=new HashSet<String>(set1),retainSet=new HashSet<String>(set1);
	      unionSet.addAll(set2);
	      retainSet.retainAll(set2);
	      System.out.println(retainSet.size());
	      System.out.println(unionSet.size());
	      
	      
	      sc.close();
	  }


	  public static void main(String[] args) throws FileNotFoundException {
	      new T33T5720().run("csp/T33T5720.txt");
	  }
	}