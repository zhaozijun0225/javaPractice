package leetcode;

import java.util.*;

public class T76 {
    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";


        int l = 0, r = 0, n = s.length(), ansLeft = -1, ansRight = n, check = 0;
        int[] cnt = new int[128];
        for (char tmp : t.toCharArray()) {
            if (cnt[tmp] == 0)
                check++;
            cnt[tmp]++;
        }


        while (r < s.length()) {
            cnt[s.charAt(r)]--;
            if (cnt[s.charAt(r)] == 0)
                check--;

            while (check == 0) {
                if (r - l < ansRight - ansLeft) {
                    ansLeft = l;
                    ansRight = r;
                }
                if (cnt[s.charAt(l)] == 0) {
                    check++;
                }
                cnt[s.charAt(l)]++;
                l++;
            }
            r++;

        }
        return;
//        return ansLeft == -1 ? "" : s.substring(ansLeft, ansRight);


    }
}
