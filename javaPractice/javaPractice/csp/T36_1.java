package csp;
import java.io.*;
import java.util.*;
public class T36_1{
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./csp/eg1.txt");
		Scanner sc = new Scanner(file);
		int n=sc.nextInt();
		int k = sc.nextInt();
		int x,y;
		String command;
		char[] c;
		for (int i = 0; i < k; i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			command = sc.next();
			c=command.toCharArray();
			for (char d : c) {
				if(d=='f') {
					if(y+1<=n)
						y++;
				}
				else if(d=='b') {
					if(y-1>=1)
						y--;
				}
				else if(d=='l') {
					if(x-1>=1)
						x--;
				}
				else if(d=='r') {
					if(x+1<=n)
						x++;
				}
			}
			System.out.println(x+" "+y);
			
			
		}
		
		
		
		
		
		
		sc.close();
	}
	
}