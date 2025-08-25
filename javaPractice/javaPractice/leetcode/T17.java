package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class T17 {
    static String[] mapButton = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static Deque<String> ans = new ArrayDeque<>();
    static void dfs(String digits, int idx, String spr){
        if(idx >= digits.length()){
            ans.push(spr);
            return;
        }

        String button = mapButton[digits.charAt(idx)-'2'];
        for (int i = 0; i < button.length(); i++) {
            dfs(digits,idx+1,spr.concat(String.valueOf(button.charAt(i))));
        }


    }


    public static void main(String[] args){
        String digits = "23";
        dfs(digits,0,"");
        Iterator<String> it = ans.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }


}
