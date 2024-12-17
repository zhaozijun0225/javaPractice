package leetcode;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class T3291 {

	public Integer[] kmpNextSearch(String words, String target) {
		String tmp = words + "$" + target;

		Integer[] next = new Integer[tmp.length()];
		Arrays.fill(next, 0);
		for (int i = 1; i < next.length; i++) {
			int j = next[i - 1];

			while (j > 0 && tmp.charAt(j) != tmp.charAt(i)) {
				j = next[j - 1];
			}

			if (tmp.charAt(i) == tmp.charAt(j)) {
				j++;
			}
			next[i] = j;
		}

		return next;
	}

	public int minValidStrings(String[] words, String target) {
		if(target.length()==0)
			return 0;
		Integer[] dp = new Integer[target.length() + 1];
		Arrays.fill(dp,0x3fffffff);
		dp[0]=0;
		Integer[] back = new Integer[target.length()];
		Arrays.fill(back,0);
		
		for (String i : words) {
			Integer[] next = kmpNextSearch(i, target);
			
			for (int j = 0; j < back.length; j++) {
				back[j]=Math.max(back[j], next[i.length()+j+1]);
			}
			
		}
		
		
		for (int i = 1; i < dp.length; i++) {
			dp[i]=dp[i-back[i-1]]+1;
			
			if(dp[i]>target.length())
				return -1;
			
			
		}
		

		return dp[target.length()];
	}

	public static void main(String args[]) {
		String[] words = new String[] { "cbacaa" };
		String target = new String("aabacbacbc");
		new T3291().minValidStrings(words, target);

		return;
	}
}
