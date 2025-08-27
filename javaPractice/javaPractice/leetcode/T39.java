package leetcode;

import java.util.*;

public class T39 {
    static List<List<Integer>> ans = new ArrayList<>();

    static void search(int[] candidates, int target, List<Integer> choose, int idx) {
        if (target == 0) {
            ans.add(choose);
            return;
        } else if (target < 0) {
            return;
        }
        List<Integer> tmp;
        for (int i = idx; i < candidates.length; i++) {
            if(candidates[i] <= target){
                tmp = new ArrayList<Integer>(choose);
                tmp.add(candidates[i]);
                search(candidates, target - candidates[i], tmp, i);
            }
        }

    }

    public static void Question(int[] candidates, int target) {
        search(candidates, target, new ArrayList<Integer>(), 0);
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Question(candidates, target);
        return;
    }
}
