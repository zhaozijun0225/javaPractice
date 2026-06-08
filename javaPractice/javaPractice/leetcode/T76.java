package leetcode;

import java.util.*;

public class T76 {
    static int charToId(char c) {
        if (c <= 'Z')
            return c - 'A';
        else
            return c - 'a'+26;

    }

    public String minWindow(String s, String t) {
        int ls = s.length(), lt = t.length();
        int[] diff = new int[52];
        int diffCnt = 0;
        for (char c : t.toCharArray()) {
            int tmpInt = charToId(c);
            if (diff[tmpInt]++ == 0) {
                diffCnt++;
            }
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (--diff[charToId(sc[i])] == 0) {
                diffCnt--;
            }
            while (diffCnt == 0) {
                if(i - left + 1<minLen){
                    ans = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }


                if (diff[charToId(sc[left])]++ == 0) {
                    diffCnt++;
                }
                left++;
            }


        }
        return ans;


    }

}
