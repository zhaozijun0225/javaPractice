package leetcode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class T128 {
	public int longestConsecutive(int[] nums) {
		if(nums.length==0)
			return 0;

		Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
		int ans = 1,count,tmpInt1;
		for(int it:set){

			if(set.contains(it-1))
				continue;

			count = 1;
			tmpInt1 = it;
			while(set.contains(tmpInt1+1)){
				count++;
				tmpInt1++;
			}
			ans = Math.max(ans,count);





		}
		return ans;

	}

}