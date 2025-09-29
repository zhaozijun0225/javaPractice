package leetcode;

import java.util.ArrayList;
import java.util.*;

public class T131 {

    static void search(List<List<String>> ans, String str, List<String> tmpAns) {
        if (str.isEmpty()) {
            ans.add(new ArrayList<>(tmpAns));
            return;
        }


        String tmpStr;
        int i, j;
        boolean found = false;
        for (i = 1; i <= str.length(); i++) {
            tmpStr = str.substring(0, i);
            found = true;
            for (j = 0; j < tmpStr.length() / 2; j++) {
                if(tmpStr.charAt(j)!= tmpStr.charAt(tmpStr.length() - j - 1)) {found = false; break;}
            }
            if (found) {
                tmpAns.add(tmpStr);
                search(ans, str.substring(i), tmpAns);
                tmpAns.removeLast();
            }


        }


    }


    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = new ArrayList<List<String>>();
        ArrayList<String> tmp = new ArrayList<>();
//        tmp = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            tmp.add(String.valueOf(s.charAt(i)));
//        }
//        ans.add(tmp);
        search(ans, s, tmp);


//        return ans;
        System.out.println(ans);


    }
}
