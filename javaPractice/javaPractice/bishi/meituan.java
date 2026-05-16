package bishi;

import java.io.*;
import java.util.Scanner;

public class meituan {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out, false);
        int T = in.nextInt();
        int n, tmpInt1, num, ans, x, idx;
        int[] arr, count;
        for (; T > 0; T--) {
            n = in.nextInt();
            arr = new int[n];
            count = new int[n];
            arr[0] = in.nextInt();
            count[0] = 1;
            ans = count[0];
            num = 1;
            pw.printf("%d ", ans);
            for (tmpInt1 = 1; tmpInt1 < n; tmpInt1++) {
                x = in.nextInt();
                //二分找第一个x小于元素的
                idx = findArr(arr, num, x);
                if (idx == num) {
                    num++;
                    count[idx]++;
                    ans ^= count[idx];
                    arr[idx] = x;
                } else {
                    ans ^= count[idx];
                    count[idx]++;
                    ans ^= count[idx];
                    arr[idx] = x;
                }
                pw.printf("%d ", ans);
            }
            pw.printf("\n");


        }


        try {
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static int findArr(int[] arr, int num, int x) {
//        找第一个x小于元素的
        int left = 0, right = num - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > x) {
                if (mid != 0) {
                    if (arr[mid - 1] < x) {
                        return mid;
                    } else {
                        right = mid - 1;
                        continue;
                    }
                } else {
                    return mid;
                }
            } else {
                left = mid + 1;
            }

        }
        return left;


    }


}
