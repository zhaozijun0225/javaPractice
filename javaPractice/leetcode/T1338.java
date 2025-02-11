package leetcode;

import java.util.*;
import java.util.Map.Entry;

import org.opentest4j.TestAbortedException;

public class T1338 {

	public int run(int[] arr) {

		int len = arr.length, ans = 0, count = 0;

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i=0;i<len;i++) {
//			m.put(arr[i], m.containsKey(arr[i]) ? m.get(arr[i]) + 1 : 1);
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
			
		}

		List<Map.Entry<Integer, Integer>> l = new ArrayList<Map.Entry<Integer, Integer>>(m.entrySet());
		Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
				return m2.getValue() - m1.getValue();
			}
		});

		for (Entry<Integer, Integer> entry : l) {
			ans++;
			count += entry.getValue();
			if (count >= len / 2)
				break;

		}

		return ans;
	}
	
	
	
//	 public int minSetSize(int[] arr) {
//	        Map<Integer, Integer> map = new HashMap<>();
//	        for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
//	        List<Integer> list = new ArrayList<>();
//	        for (int x : map.keySet()) {
//	            list.add(map.get(x));
//	        }
//	        Collections.sort(list, (a, b) -> b - a);
//	        int sum = 0;
//	        for (int i = 0; i < list.size(); i++) {
//	            sum += list.get(i);
//	            if (sum >= arr.length/2)return i+1;
//	        }
//	        return list.size();
//	    }
	

	public static void main(String[] args) {
		int[] tmp = new int[] { 9, 77, 63, 22, 92, 9, 14, 54, 8, 38, 18, 19, 38, 68, 58, 19 };
		new T1338().run(tmp);

	}
}
