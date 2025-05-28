package leetcode;

import java.util.*;

public class T438 {

    public List<Integer> run(String s,String p){
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int WSize=p.length();
        char[] tmpChar=s.toCharArray();
        int okFlag=map.keySet().size();

        for(int i=0;i<s.length();i++){
            if(i>=WSize){
                if(map.get(tmpChar[i-WSize])==0){
                    okFlag++;
                }
                map.put(tmpChar[i-WSize],map.get(tmpChar[i-WSize])+1);
                if(map.get(tmpChar[i-WSize])==0){
                    okFlag--;
                }
            }

            if(map.getOrDefault(tmpChar[i],0)==0){
                okFlag++;
            }
            map.put(tmpChar[i],map.getOrDefault(tmpChar[i],0)-1);
            if(map.get(tmpChar[i])==0){
                okFlag--;
            }
            if(okFlag==0){
                ans.add(i+1-WSize);
            }



        }


        return ans;
    }


    public static void main(String[] args) {
        List<Integer> ans=new T438().run("cbaebabacd", "abc");

        System.out.println(ans);

    }

}
