package csp;


import java.io.*;
import java.util.*;

public class T21_2V2 {

	
	
  public void run(String filename) throws FileNotFoundException {
      File file = new File(filename);
//      Scanner sc = new Scanner(file);
      Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(file)));
      
      int m=sc.nextInt();
      Integer[] positive=new Integer[(int)1e8+2]; 
      Integer[] negtive=new Integer[(int)1e8+2];
      Arrays.fill(positive, 0);
      Arrays.fill(negtive, 0);
      int ans=0;
      int maxScore=0;
      int tmpScore;
      int truth,val;
      for (int i = 0; i < m; i++) {
    	  val=sc.nextInt();truth=sc.nextInt();
    	  if(truth==1)
	    	  positive[val+1]++;
	      else 
			negtive[val+1]++;
	}

      
      
      for (int i = 0; i < (int)1e8+1; i++) {
		positive[i+1]+=positive[i];
		negtive[i+1]+=negtive[i];
		tmpScore=negtive[i]-positive[i];
		if(tmpScore>=maxScore) {
  		  maxScore=tmpScore;
  		  ans=i;
  		  
  	  }
      }

      System.out.print(ans);

      sc.close();
  }


  public static void main(String[] args) throws FileNotFoundException {
      new T21_2V2().run("./csp/eg1.txt");
  }
}