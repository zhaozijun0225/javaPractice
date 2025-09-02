package leetcode;

import java.util.*;

public class T22 {
    static void dfs(List<String> ans, int num, String toAdd, int leftNum){
        if(num==0 && leftNum==0){
            ans.add(toAdd);
            System.out.printf("%s",toAdd);
            return;
        }

        if(num>0){
            dfs(ans, num-1, toAdd.concat("("), leftNum+1);
        }
        if(leftNum>0){
            dfs(ans, num, toAdd.concat(")"), leftNum-1);
        }



    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new ArrayList<>();
        dfs(ans,n,"",0);
        return;
    }
}
