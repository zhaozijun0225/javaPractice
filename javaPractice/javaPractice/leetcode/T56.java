package leetcode;

import java.util.*;

/**
 * @Author: zijun.zhao
 * @Date: 2026/6/11 上午4:21
 */

public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>(intervals.length);
        ans.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i = 1;i< intervals.length;i++){
            int[] last = ans.getLast();
            if(intervals[i][0]<=last[1]){
                if(intervals[i][1]>last[1])
                    last[1] = intervals[i][1];
            }else{
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }



        }

        return ans.toArray(new int[ans.size()][]);


    }
}
