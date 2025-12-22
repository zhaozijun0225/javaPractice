package leetcode;

public class T4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};


        if (nums1.length > nums2.length) {
            int[] n1 = nums1;
            nums1 = nums2;
            nums2 = nums1;
        }
        int L1 = nums1.length, L2 = nums2.length;
        int l = 0, r = L1 - 1, mid = 0;
        int intTmp1, intTmp2;
        boolean isFull = false;
        while (l <= r) {
            mid = (l + r) / 2;

            intTmp2 = (L1 + L2 - 2 * mid + 1) / 2;

            if (mid == L1 - 1) {
                isFull = true;
                break;
            }

            if (nums1[mid] >= nums2[intTmp2 + 1]) {
                r = mid - 1;
            } else {
                if (nums1[mid + 1] <= nums2[(L1 + L2 - 2 * mid - 1) / 2]) {
                    l = mid + 1;
                }
            }
        }

        intTmp1 = (L1 + L2 - 2 * mid + 1) / 2;
        if((L1+L2) %2==1){
            if(isFull){
                return nums2[intTmp1];
            }else{
                return Math.max(nums1[mid],nums2[intTmp1]);
            }
        }else{
            if(isFull){
                return (nums2[intTmp1]+nums2[intTmp1+1])/2;
            }else{
                return (Math.max(nums1[mid],nums2[intTmp1]) + Math.min(nums1[mid+1],nums2[intTmp1+1]))/2;
            }
        }

    }
}
