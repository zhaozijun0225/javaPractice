package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class T1847 {

	public int[] closestRoom(int[][] rooms, int[][] queries) {
		int[] ans = new int[queries.length];
		Arrays.fill(ans, -1);

		Arrays.sort(rooms, (a, b) -> (b[1] - a[1]));

		Integer[] queryId = new Integer[queries.length];
		Arrays.setAll(queryId, i -> i);
		Arrays.sort(queryId, (a, b) -> queries[b][1] - queries[a][1]);

		TreeSet<Integer> roomId = new TreeSet<Integer>();

		int diff, preferredId, minSize, j = 0;
		Integer floor, ceil;
		for (int i : queryId) {
			preferredId = queries[i][0];
			minSize = queries[i][1];
			while (j < rooms.length && rooms[j][1] >= minSize) {
				roomId.add(rooms[j][0]);
				j++;
			}

			diff = Integer.MAX_VALUE;

			floor = roomId.floor(preferredId);
			ceil = roomId.ceiling(preferredId);
			if (null != floor) {
				diff = preferredId - floor;
				ans[i] = floor;
			}

			if (ceil != null && ceil - preferredId < diff) {
				ans[i] = ceil;
			}

		}

		return ans;
	}

	public static void main() {

		int[][] rooms = { { 11, 6 }, { 6, 11 }, { 1, 22 }, { 20, 2 }, { 21, 7 }, { 8, 15 }, { 4, 17 }, { 13, 22 },
				{ 17, 16 }, { 22, 11 } }, queries = { { 7, 12 } };

		new T1847().closestRoom(rooms, queries);

		return;
	}

}

//	public class room {
//		int id, size;
//
//		room() {
//		}
//
//		room(int id, int size) {
//			this.id = id;
//			this.size = size;
//		}
//	}
//
//	public class querie {
//		int prefer, minsize, originidx;
//
//		querie() {
//		}
//
//		querie(int prefer, int minsize, int originidx) {
//			this.prefer = prefer;
//			this.minsize = minsize;
//			this.originidx = originidx;
//		}
//	}
//
//	private int binary_search(room[] m, int id) {
//		int f = 0, l = 0, r = m.length - 1, ans = 0, tmpmin = 0x3fffffff, i;
//		boolean is_iter=false;
//		if (id >= m[r].id)
//			return r;
//		else if (id < m[0].id)
//			return 0;
//
//		outer: while (l <= r && !is_iter) {
//			f = (l + r) / 2;
//
//			if (m[f].id == id) {
//				ans = m[f].id == id ? f : ans;
//				break outer;
//			} else {
//
//				if (r - l > 3) {
//					if (Math.abs(m[r].id - id) <= tmpmin) {
//						tmpmin = Math.abs(m[r].id - id);
//						ans = r;
//					} 
//					if (Math.abs(m[f].id - id) <= tmpmin) {
//						tmpmin = Math.abs(m[f].id - id);
//						ans = f;
//					}
//					if (Math.abs(m[l].id - id) <= tmpmin) {
//						tmpmin = Math.abs(m[l].id - id);
//						ans = l;
//					}
//				} else {
//					is_iter=true;
//					for (i = 0; r - i >= l; i++) {
//						if (Math.abs(m[r - i].id - id) <= tmpmin) {
//							tmpmin = Math.abs(m[r - i].id - id);
//							ans = r - i;
//						}
//
//					}
//				}
//
//				if (m[f].id < id) {
//					l = f + 1;
//				} else {
//					r = f - 1;
//				}
//
//			}
//
//		}
//
//		return ans;
//	}
//
//	public int[] closestRoom(int[][] rooms, int[][] queries) {
//		int[] ans = new int[queries.length];
//		int i = 0;
//		room[] r = new room[rooms.length];
//		querie[] q = new querie[queries.length];
//		room tmproom;
//		querie tmpquerie;
//
//		for (i = 0; i < rooms.length; i++) {
//			tmproom = new room(rooms[i][0], rooms[i][1]);
//			r[i] = tmproom;
//		}
//		for (i = 0; i < queries.length; i++) {
//			tmpquerie = new querie(queries[i][0], queries[i][1], i);
//			q[i] = tmpquerie;
//		}
//
//		Arrays.sort(r, new Comparator<room>() {
//			@Override
//			public int compare(room o1, room o2) {
//				return o1.id - o2.id;
//			}
//		});
//
//		Arrays.sort(q, new Comparator<querie>() {
//			@Override
//			public int compare(querie o1, querie o2) {
//
//				return o1.prefer == o2.prefer ? o1.minsize - o2.minsize : o1.prefer - o2.prefer;
//			}
//		});
//
//		int tmpprefer = 0, tmpminsize = 0, ls = 0, rs = 0, tmpindex = -1;
//		boolean is_find = false;
//		for (i = 0; i < q.length; i++) {
//			tmpprefer = q[i].prefer;
//			tmpminsize = q[i].minsize;
//
//			if (tmpprefer != tmpindex) {
//				tmpindex = tmpprefer;
//				ls = binary_search(r, tmpprefer);
//				rs = ls;
//			}
//
//			is_find_left = false,is_find_right = false;
//			while (ls >= 0 || rs < r.length) {
//				if (ls >= 0 && r[ls].size >= tmpminsize) {
//					is_find = true;
//					ans[q[i].originidx] = r[ls].id;
//					break;
//				} else if (rs < r.length && r[rs].size >= tmpminsize) {
//					is_find = true;
//					ans[q[i].originidx] = r[rs].id;
//					break;
//				}
//
//				ls--;
//				rs++;
//
//			}
//			if (!is_find) {
//				ans[q[i].originidx] = -1;
//
//			}
//
//		}
//
//		return ans;
//	}
//
//	public static void main(String[] args) {
////		int[][] rooms = { { 23, 22 }, { 6, 20 }, { 15, 6 }, { 22, 19 }, { 2, 10 }, { 21, 4 }, { 10, 18 }, { 16, 1 },
////				{ 12, 7 }, { 5, 22 } },
////				queries = { { 12, 5 }, { 15, 15 }, { 21, 6 }, { 15, 1 }, { 23, 4 }, { 15, 11 }, { 1, 24 }, { 3, 19 },
////						{ 25, 8 }, { 18, 6 } };
//		int[][] rooms = {{11,6},{6,11},{1,22},{20,2},{21,7},{8,15},{4,17},{13,22},{17,16},{22,11}}, queries = { { 7, 12 } };
//
//		new T1847().closestRoom(rooms, queries);
//
//		return;
//	}
//}
