package leetcode;

import java.util.*;

public class T79 {

    static int[][] forward = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static boolean search(boolean[][] flag, char[][] board, String word, int x, int y) {
        if(word.isEmpty()) return false;
        int tmpx, tmpy;
        boolean found = false;
        for (int i = 0; i < forward.length; i++) {
            tmpx = x + forward[i][0];
            tmpy = y + forward[i][1];
            if (tmpx >= 0 && tmpx < board.length && tmpy >= 0 && tmpy < board[0].length) {
                if (board[tmpx][tmpy] == word.charAt(0) && !flag[tmpx][tmpy]) {
                    if (word.length() == 1) {
                        return true;
                    } else {
                        flag[tmpx][tmpy] = true;
                        found = search(flag, board, word.substring(1), tmpx, tmpy);
                        if (found) {
                            return true;
                        }
                        flag[tmpx][tmpy] = false;

                    }
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean ans = false;
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < flag.length; i++) {
            Arrays.fill(flag[i], false);
        }



        for (int i = 0; i < board.length; i++) {
            if (ans) break;
            for (int j = 0; j < board[0].length; j++) {
                if (ans) break;
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        ans =  true;
                    }
                    else{
                        flag[i][j] = true;
                        ans = search(flag, board, word.substring(1), i, j);
                        flag[i][j] = false;
                    }

                }
            }
        }


        System.out.println(ans);
//        return ans;
    }
}
