package leetcode;

import java.util.*;
import java.io.*;

public class T49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] arr = new int[26];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(arr, 0);
            for (char c : strs[i].toCharArray()) {
                arr[c - 'a']++;
            }
            sb.setLength(0);
            for (int j = 0; j < 26; j++) {
                if (arr[j] != 0) {
                    sb.append((char) ('a' + j)).append(arr[j]);
                }
            }

            map.putIfAbsent(sb.toString(), new ArrayList<String>());
            List<String> l = map.get(sb.toString());
            l.add(strs[i]);

        }

        List<List<String>> ans = new LinkedList<>();

        for(List l:map.values()){
                ans.add(l);
        }

        return ans;

    }

}
