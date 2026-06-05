package leetcode;

import java.util.*;

public class T438 {

    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length())
            return new ArrayList<>(4);
        char[] arrS = s.toCharArray(), arrP = p.toCharArray();


        int pLen = p.length();
        List<Integer> ans = new ArrayList<>(30000);

        int[] pCount = new int[26];
        int[] testCount = new int[26];
        int r = 0;
        for (int i = 0; i < pLen; i++) {
            pCount[arrP[i] - 'a']++;
            testCount[arrS[r++] - 'a']++;
        }
        int left = 0;
        if (Arrays.equals(pCount, testCount))
            ans.add(left);

        for (;r < s.length(); r++) {
            testCount[arrS[left++]-'a']--;
            testCount[arrS[r]-'a']++;

            if (Arrays.equals(pCount, testCount))
                ans.add(left);

        }


        return ans;
    }

}
