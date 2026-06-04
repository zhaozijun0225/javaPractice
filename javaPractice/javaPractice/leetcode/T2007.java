package leetcode;

import java.util.*;

public class T2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if ((n & 1) == 1)
            return new int[0];

        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : changed) {
            cnt.merge(x, 1, Integer::sum);
        }
        int cnt0 = cnt.getOrDefault(0, 0);
        if ((cnt0 & 1) == 1) {
            return new int[0];
        }
        int[] ans = new int[n >> 1];
        int ansIdx = cnt0>>1;

        for(int x:cnt.keySet()){
            if((x&1)==0 && cnt.get(x>>1)!=0 || cnt.get(x)==0){
                continue;
            }
            int tmpInt = x;
            while(cnt.containsKey(tmpInt)){
                if(cnt.get(tmpInt)==0){
                    tmpInt<<=1;
                    continue;

                }

                int cntx = cnt.get(tmpInt);
                int cnty = cnt.getOrDefault(tmpInt<<1,0);
                if(cntx>cnty)
                    return new int[0];
                Arrays.fill(ans,ansIdx,ansIdx+=cntx,tmpInt);

                cnt.put(tmpInt,0);
                cnt.put(tmpInt<<1,cnty-cntx);
                tmpInt<<=1;
            }

        }

        return ans;
    }
}
