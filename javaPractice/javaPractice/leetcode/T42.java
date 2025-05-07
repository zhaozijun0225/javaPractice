package leetcode;

//这是自己在本地测试样例时候用的
import java.io.*;
import java.util.*;

import javax.swing.tree.FixedHeightLayoutCache;

public class T42 {

	public class box {
		int height;
		int idx;

		public box(int height, int idx) {
			this.height = height;
			this.idx = idx;

		}

	}

	public int run(int[] height) throws FileNotFoundException {
		int max = 0, ans = 0, maxidx = 0, minHeight;
		box tmp1, lastPollBox;
		Deque<box> deque = new ArrayDeque<box>();
//		Deque<box> alreadyDeque = new ArrayDeque<box>();

		for (int idx = 0; idx < height.length; idx++) {
			if (!deque.isEmpty()) {
				lastPollBox = null;
				while (deque.peek().height <= height[idx]) {
					// 左低，算一行的分
					tmp1 = deque.poll();

					minHeight = tmp1.height;

					if (lastPollBox != null) {
						minHeight -= lastPollBox.height;
					}

					ans += (idx - tmp1.idx - 1) * minHeight;

					lastPollBox = tmp1;
					if (deque.isEmpty()) {
						break;
					}

				}
				if (!deque.isEmpty()) {
					// 左有高的，算分
					tmp1 = deque.peek();
					minHeight = height[idx];
					if (lastPollBox != null) {
						minHeight -= lastPollBox.height;
					}
					ans += (idx - tmp1.idx - 1) * minHeight;

				}

			}
			deque.push(new box(height[idx], idx));

		}

		return ans;
	}

	public static void main(String[] args) throws FileNotFoundException {
		int ans = new T42().run(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });

		System.out.print(ans);
	}
}