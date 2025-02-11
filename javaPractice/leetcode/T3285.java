package leetcode;

import java.util.*;


public class T3285 {
	
	public List<Integer> stableMountains(int[] height,int threshold){
		List<Integer> index=new LinkedList<Integer>();
		
		for (int i = 1; i < height.length; i++) {
			if(height[i-1]>threshold)
				index.add(i);
		}
		
		
		return index;
	}
	
	
	
	public static void name() {
		
		
		
		int[] height=new int[] {1,2,3,4,5};
		int threshold=2;
		new T3285().stableMountains(height,threshold);
		
	}
}
