package leetcode;

import java.io.*;
import java.util.*;

import org.hamcrest.text.IsEmptyString;

public class T128 {

	public int run(int[] nums) throws FileNotFoundException {
//      File file = new File(filename);
//      Scanner sc = new Scanner(file);

		HashSet<Integer> t = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			t.add(nums[i]);
		}

		int ans = 0, tmp1, tmp2;

		for (int num : t) {
			if (!t.contains(num - 1)) {
				tmp1 = 1;
				tmp2 = num;
				while (t.contains(tmp2 + 1)) {
					tmp2++;
					tmp1++;
				}
				ans = tmp1 > ans ? tmp1 : ans;

			}

		}

		return ans;
//      sc.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		int ans = new T128().run(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 });
		System.out.print(ans);
	}
}