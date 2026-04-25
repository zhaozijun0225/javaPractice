package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList();

        int[] last = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            last[chars[i] - 'a'] = i;
        }

        int start = 0,end = 0;
        while(end<s.length()){
            for (int i = start; i <= end; i++) {
                end = Math.max(end,last[chars[i] - 'a']);
            }
            ans.add(end-start+1);
            start = end+1;
            end = start;
        }



        return ans;
    }

}
