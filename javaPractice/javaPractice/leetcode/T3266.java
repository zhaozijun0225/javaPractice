package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.hamcrest.SelfDescribing;

public class T3266 {
	static class numsWithIndex {
		int index;
		long num;

		numsWithIndex(int index, long num) {
			this.index = index;
			this.num = num;

		}

	}

	public int fast_power(int a, int b, int p) {
		int ans = 1;
		while (b > 0) {
			if ((b & 1) != 0)
				ans = (int) ((long) ans * a % p);
			a = (int) ((long)a * a % p);
			b >>= 1;
		}

		return ans;
	}

	public int[] run(int[] nums, int k, int multiplier) {
		if(multiplier==1) return nums;
		PriorityQueue<numsWithIndex> minKQueue = new PriorityQueue<numsWithIndex>(new Comparator<numsWithIndex>() {
			public int compare(numsWithIndex o1, numsWithIndex o2) {
				return o1.num == o2.num ? o1.index - o2.index : (o1.num > o2.num ? 1:-1);
			}
		});
		
		int maxIndex=-1,maxnum=0,MOD=(int)1e9+7;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>maxnum) {
				maxnum=nums[i];
				maxIndex=i;
			}
			minKQueue.offer(new numsWithIndex(i, nums[i]));
		}

		numsWithIndex tmp;
		
		while(k>0) {
			tmp = minKQueue.poll();
			minKQueue.offer(new numsWithIndex(tmp.index, tmp.num * multiplier));
			k--;
			if(tmp.index==maxIndex) break;
		}
		
		
		
		for (int i = 0; i < nums.length; i++) {
			tmp = minKQueue.poll();
			nums[tmp.index]=(int)(tmp.num%MOD*this.fast_power(multiplier, k/nums.length+(i<k%nums.length?1:0), MOD)%MOD);
			
		}
		

		return nums;

	}

	public static void main(String[] args) {
		int[] tmp = new int[] { 161209470 };
		new T3266().run(tmp, 56851412, 39846);
	}
}
