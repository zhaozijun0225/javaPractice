package leetcode;

import java.util.*;

public class T51 {
    static void search(List<List<String>> ans, char[][] tmpAns, int n, int row, int col, int diag1, int diag2) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for(char[] c : tmpAns) list.add(new String(c));
            ans.add(list);
            return;
        }

        int pos, j;
        int avai = ((1<<n)-1) & ~(col | diag1 | diag2);
        while(avai != 0) {
            pos = avai & -avai; //取最右边第一次出现的1
            avai &= avai -1; // 去掉刚找的那个1
            j = Integer.bitCount(pos - 1); //刚才那个pos只有一个位上有1，-1后数有几个1，就知道他是第几个
            tmpAns[row][j] = 'Q';
            search(ans, tmpAns, n, row+1, col | pos, (diag1 | pos)<<1, (diag2 | pos)>>1);
            tmpAns[row][j] = '.'; //还原
        }


    }

    public static void main(String[] args) {
        int n = 4;

        List<List<String>> ans = new ArrayList<List<String>>();
        char[][] tmpAns = new char[n][n];
        for (char[] c : tmpAns) Arrays.fill(c, '.');


        search(ans, tmpAns, n, 0, 0, 0, 0);


//        return ans;
        System.out.println(ans);
    }
}
