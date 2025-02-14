package csp;
import java.util.*;
import java.util.function.IntPredicate;
import java.io.*;


public class T36_2{
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
	
	public static void main(String[] args) throws FileNotFoundException {
		File file=new File("./csp/eg1.txt");
		Scanner sc = new Scanner(file);
		int n=sc.nextInt();
		int[] a=new int[n+1],b=new int[n+1],ans=new int[n+1],premax=new int[n+1],sufmax=new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			a[i]=sc.nextInt();
		}
		
		ans[0] = a[0];
		for (int i = 1; i <= n; i++) {
			b[i]=sc.nextInt();
			ans[i]=ans[i-1]+a[i]-b[i];
			premax[i]=Math.max(ans[i], premax[i-1]);
		}
		sufmax[n]=ans[n];
		ans[n]=Math.max(sufmax[n]+b[n], premax[n]);
		for (int i = n-1; i >0; i--) {
			sufmax[i]=Math.max(sufmax[i+1], ans[i]);
			ans[i]=Math.max(sufmax[i]+b[i], premax[i]);
		}
		
		
		for (int i = 1; i <=n; i++) {
//			System.out.printf("%d ",ans[i]);
			out.printf("%d ",ans[i]);
		}
		out.flush();
		
		
		sc.close();
	}
	
}