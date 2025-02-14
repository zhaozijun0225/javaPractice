package csp;


import java.io.*;
import java.util.*;

public class T21_2 {

	static class Pair{
		int value;
		int truth;
		
		Pair(int value,int truth){
			this.value=value;
			this.truth=truth;
		}
	}
	
  public void run(String filename) throws FileNotFoundException {
      File file = new File(filename);
//      Scanner sc = new Scanner(file);
      Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(file)));
      int m=sc.nextInt();
      Pair[] p=new Pair[m]; 
      Integer[] positive=new Integer[m+1]; 
      Integer[] negtive=new Integer[m+1];
      Integer[] value=new Integer[m+1];
      Arrays.fill(positive, 0);
      Arrays.fill(negtive, 0);
      Arrays.fill(value, 0);
      for (int i = 0; i < m; i++) {
    	  p[i]=new Pair(sc.nextInt(),sc.nextInt());
	}
      
      Arrays.sort(p,(a,b)->a.value-b.value);
      
      
      value[1]=p[0].value;
      int count=1;
      if(p[0].truth==1)
    	  positive[1]++;
      else 
		negtive[1]++;
	
     
      
      for (int i = 1; i < m; i++) {
		if(p[i].value==value[count]) {
			if(p[i].truth==1)
		    	  positive[count]++;
		      else 
				negtive[count]++;
		
		}
		else {
			count++;
			value[count]=p[i].value;
			if(p[i].truth==1)
		    	  positive[count]++;
		      else 
				negtive[count]++;
		}
      }
      
      for (int i = 0; i < count; i++) {
		positive[i+1]+=positive[i];
		negtive[i+1]+=negtive[i];
	
      }
      
      int ans=value[1];
      int maxScore=positive[count];
      int tmpScore;
      
      
      for (int i = 1; i < count; i++) {
    	  tmpScore=negtive[i]+positive[count]-positive[i];
    	  if(tmpScore>=maxScore) {
    		  maxScore=tmpScore;
    		  ans=value[i+1];
    		  
    	  }
      }
      
      
      
      
      System.out.print(ans);
      
      
      
      
      sc.close();
  }


  public static void main(String[] args) throws FileNotFoundException {
      new T21_2().run("./csp/eg1.txt");
  }
}