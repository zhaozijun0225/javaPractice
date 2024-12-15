package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.hamcrest.SelfDescribing;

public class T3264 {
	static class numsWithIndex {
		int index, num;

		numsWithIndex(int index, int num) {
			this.index = index;
			this.num = num;
		}

	}

	public void run(int[] nums, int k, int mul) {
		PriorityQueue<numsWithIndex> minKQueue = new PriorityQueue<numsWithIndex>(new Comparator<numsWithIndex>() {
			public int compare(numsWithIndex o1, numsWithIndex o2) {
				if(o1.num==o2.num) 
					return o1.index<o2.index?-1:1;
				else {
					return o1.num-o2.num;
				}
				
					
					
				
				
				
			}
		});

		for (int i = 0; i < nums.length; i++) {
			minKQueue.offer(new numsWithIndex(i,nums[i]));
		}
		
		numsWithIndex tmp;
		
		for (int i = 0; i < k; i++) {
			tmp=minKQueue.poll();
			minKQueue.offer(new numsWithIndex(tmp.index, tmp.num * mul));
		}
		
		for (numsWithIndex tmp2 : minKQueue) {
			nums[tmp2.index]=tmp2.num;
		}
		
		
		return nums;

	}

	public static void main(String[] args) {
		int[] tmp = new int[] { 2, 1, 3, 5, 6 };
		new T3264().run(tmp, 5, 2);
	}
}
