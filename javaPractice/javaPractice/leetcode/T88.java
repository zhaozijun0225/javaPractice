package leetcode;

public class T88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        int[] tmp = new int[nums1.length];
        System.arraycopy(nums1, 0, tmp, 0, m);
        int idx = 0, idxA = 0, idxB = 0;
        while (m > idxA && n > idxB) {
            if (tmp[idxA]>nums2[idxB]){
                nums1[idx] = nums2[idxB];
                idxB++;
            }
            else{
                nums1[idx] = tmp[idxA];
                idxA++;
            }
            idx++;
        }

        if(idxA==m){
            System.arraycopy(nums2,idxB,nums1,idx,n-idxB);
        }
        else{
            System.arraycopy(tmp,idxA,nums1,idx,m-idxA);

        }



    }
}
