package leetcode;

import java.util.Iterator;

public class T2931 {

	public static long ttt(int[][] values) {
		int m = values.length;
		int n = values[0].length;
		int i, j, tmp_i, min = 0x7fffffff;
		long sum = 0;
		int[] rem = new int[m];
		for (i = 1; i <= m; i++) {
			rem[i - 1] = n - 1;
		}

		for (i = 1; i <= n * m; i++) {
			min = 0x7fffffff;
			tmp_i = -1;
			for (j = 0; j < m; j++) {
				if (rem[j] >= 0) {
					if (values[j][rem[j]] < min) {
						min = values[j][rem[j]];
						tmp_i = j;
					}
				}
			}
			sum += (long)min * i;
			rem[tmp_i]--;

		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] inputData = new int[][] { { 8, 5, 2 }, { 6, 4, 1 }, { 9, 7, 3 } };

		int ans = T2931.ttt(inputData);
		System.out.println(ans);
		return;
	}
}
