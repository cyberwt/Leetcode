package binarySearch.array;

/**
 * 一个重点：Nth means here, Nth means from this index is 1
 * 不断二分回切： 是getKth(nums1, k1th+kth/2-1+1, nums2,k2th, kth-kth/2); 算的
 *
 * T:O(NlogN) S:O(1)
 *
 * 6/22/20.
 */
public class _4_median_of_two_sorted_arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //CC remove, don't need to
        int m=nums1.length;
        int n=nums2.length;
        if((m+n)%2 == 0){
            return (getKth(nums1,0,nums2,0,(m+n)/2) + getKth(nums1,0,nums2,0,(m+n)/2+1))/2.0;
        }else{
            return getKth(nums1,0,nums2,0,(m+n)/2+1);
        }
    }

    public double getKth(int[] nums1, int k1th,int[] nums2, int k2th, int kth){
        if(k1th>=nums1.length){
            return nums2[k2th+kth-1];
        }
        if(k2th>=nums2.length){
            return nums1[k1th+kth-1];
        }
        if(kth == 1){
            return Math.min(nums1[k1th],nums2[k2th]);
        }

        int mid1 = k1th+kth/2-1>=nums1.length? Integer.MAX_VALUE:nums1[k1th+kth/2-1];
        int mid2 = k2th+kth/2-1>=nums2.length? Integer.MAX_VALUE:nums2[k2th+kth/2-1];

        if(mid1<mid2){
            return getKth(nums1, k1th+kth/2-1+1, nums2,k2th, kth-kth/2);
        }else{
            return getKth(nums1, k1th, nums2,k2th+kth/2-1+1, kth-kth/2);
        }
    }

    public static void main(String[] args) {
        _4_median_of_two_sorted_arrays solution = new _4_median_of_two_sorted_arrays();
        int[] num1 = {3,7,7,7,9,10};
        int[] num2 = {2,4,5,6,44};
        double res = solution.findMedianSortedArrays(num1,num2);
        System.out.println(res);
    }
}
