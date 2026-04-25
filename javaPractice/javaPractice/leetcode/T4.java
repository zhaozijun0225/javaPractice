package leetcode;

public class T4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if ((n + m) % 2 == 0) {
            return (findMid(nums1, 0, n, nums2, 0, m, (m + n) / 2) + findMid(nums1,0, n, nums2,0, m, (m + n) / 2 + 1)) / 2.0;
        } else {
            return findMid(nums1, 0, n, nums2, 0, m, (m + n + 1) / 2);
        }

    }

    private int findMid(int[] nums1, int Astrat, int Aend, int[] nums2, int Bstart, int Bend, int k) {
        int lenA = Aend - Astrat, lenB = Bend - Bstart;
        if (lenA == 0)
            return nums2[Bstart + k - 1];
        else if (lenB == 0)
            return nums1[Astrat + k - 1];

        if (k == 1)
            return Math.min(nums1[Astrat], nums2[Bstart]);

        int tmpI1 = Astrat + Math.min(lenA, k / 2) - 1;
        int tmpI2 = Bstart + Math.min(lenB, k / 2) - 1;
        if (nums1[tmpI1] > nums2[tmpI2]) {
            return findMid(nums1, Astrat, Aend, nums2, tmpI2 + 1, Bend, k - (tmpI2 - Bstart + 1));
        }else{
            return findMid(nums1, tmpI1+1, Aend, nums2, Bstart, Bend, k - (tmpI1 - Astrat + 1));
        }


    }


    public static void main(String[] args) {


    }
}
