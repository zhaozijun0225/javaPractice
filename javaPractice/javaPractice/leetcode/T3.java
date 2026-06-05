package leetcode;
import java.util.*;

public class T3 {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        Set<Character> set = new HashSet<Character>();

        char[] arr = s.toCharArray();
        int left = 0;
        for(int right = 0;right<arr.length;right++){
            if(set.contains(arr[right])){
                while(arr[left]!=arr[right]){
                    set.remove(arr[left]);
                    left++;
                }

                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);

            ans = Math.max(ans,right-left+1);
        }




        return ans;



    }

}
