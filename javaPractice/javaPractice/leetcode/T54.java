package leetcode;

import java.util.*;

public class T54 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // right:0  down:1 left:2 up:3  forward = (forward+1) % 4;
        int forward = 0;
        List<Integer> ans = new ArrayList<>();
        int idx = 0, m = matrix.length, n = matrix[0].length, total = m * n;
        int rightLimit = n - 1, downLimit = m - 1, leftLimit = 0, topLimit = 0;



        for (int i = 0; i < total; i++) {
            ans.addLast(matrix[idx / n][idx % n]);




            if (forward == 0) {
                if (idx % n == rightLimit) {
                    forward = (forward + 1) % 4;
                    idx += n;
                    topLimit++;
                } else {
                    idx++;
                }
            } else if (forward == 1) {
                if (idx / n == downLimit) {
                    forward = (forward + 1) % 4;
                    idx -= 1;
                    rightLimit--;
                } else {
                    idx += n;
                }
            } else if (forward == 2) {
                if (idx % n == leftLimit) {
                    forward = (forward + 1) % 4;
                    idx -= n;
                    downLimit--;
                } else {
                    idx -= 1;
                }
            } else if (forward == 3) {
                if (idx / n == topLimit) {
                    forward = (forward + 1) % 4;
                    idx += 1;
                    leftLimit++;
                } else {
                    idx -= n;
                }
            }


        }
        return ans;


    }
}
