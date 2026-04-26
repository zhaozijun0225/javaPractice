package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class T300 {

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int x : nums) {
            int idx = getLoc(l, x);
            if (idx == l.size()) {
                l.addLast(x);
            } else {
                l.set(idx, x);
            }
        }
        return l.size();

    }

    private int getLoc(ArrayList<Integer> l, int x) {
        int left = 0, right = l.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(x > l.get(mid)) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return left;

    }


}
