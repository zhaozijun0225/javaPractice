package leetcode;

public class T74 {
    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
//        int[][] matrix = {{1}};
//        int target = 3;
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m - 1, mid;
        boolean isFound = false;

        while (l <= r) {
            mid = (l + r) / 2;
            if (matrix[mid][n - 1] == target) {
                isFound = true;
                break;
            } else if (matrix[mid][n - 1] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;

            }

        }
        int foundRow = m + 1;
        if (!isFound) {
            foundRow = l;
        }
        if (!isFound && foundRow < m) {
            l = 0;
            r = n - 1;
            while (l <= r) {
                mid = (l + r) / 2;
                if (matrix[foundRow][mid] == target) {
                    isFound = true;
                    break;
                } else if (matrix[foundRow][mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        System.out.println(isFound);

    }
}
